package com.nagarro.microservices.orderService.serviceimpl;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;

import com.nagarro.microservices.orderService.dao.OrderDao;
import com.nagarro.microservices.orderService.model.Order;
import com.nagarro.microservices.orderService.model.OrderStatus;
import com.nagarro.microservices.orderService.service.OrderService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@Service
public class OrderServiceImpl implements OrderService {


	@Autowired
	private EurekaClient eurekaClient;
	

	@Resource(name = "restTemplate")
	private RestTemplate restTemplate;
	
	@Autowired 
	private JmsTemplate jmsTemplate;
	
	@Resource
	OrderDao orderDao;
	
	@Override
	public Order getOrderDetails(String id) {
		return orderDao.getOrder(id);
	}

	@Override
	public String doPayment(String orderId) {

		Order order = orderDao.getOrder(orderId);
		double price = order.getAmount();
		String url = "/payment?price="+price;
		InstanceInfo instance = eurekaClient.getNextServerFromEureka("payment", false);
		double transactionId = restTemplate.getForObject(instance.getHomePageUrl()+ url, double.class);
		
		order.setTransactionId(transactionId);
		order.setOrderStatus(OrderStatus.CONFIRMED);
		orderDao.updateOrder(order);
		return "Payment is successful";
	}

	@Override
	public Order createOrder(Order order) {
		if(Objects.isNull(order.getOrderId())){
			order.setOrderId(UUID.randomUUID().toString());
		}
		order.setCreationTime(Instant.now());
		order.setOrderStatus(OrderStatus.PROCESSING);
		orderDao.saveOrder(order);
		jmsTemplate.convertAndSend("OrderServiceRequest", order);
		return order;
	}

	@Override
	@JmsListener(destination="ServiceAvaliableForOrderEvent")
	public void orderReady(String orderId) {
		Order order = orderDao.getOrder(orderId);
		order.setOrderStatus(OrderStatus.READY);
		orderDao.updateOrder(order);
	}

	@Override
	@JmsListener(destination="ServiceNotAvaliableForOrderEvent")
	public void orderUnconfirmed(String orderId) {
		Order order = orderDao.getOrder(orderId);
		order.setOrderStatus(OrderStatus.UNCONFIRMED);
		orderDao.updateOrder(order);
		
	}

}
