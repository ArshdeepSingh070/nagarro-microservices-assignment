package com.nagarro.microservices.orderService.serviceimpl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

}
