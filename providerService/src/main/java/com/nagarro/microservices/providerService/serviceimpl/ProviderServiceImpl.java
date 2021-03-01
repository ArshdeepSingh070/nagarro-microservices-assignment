package com.nagarro.microservices.providerService.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.nagarro.microservices.providerService.dao.ProviderDao;
import com.nagarro.microservices.providerService.model.AvailabilityStatus;
import com.nagarro.microservices.providerService.model.Provider;
import com.nagarro.microservices.providerService.model.ServiceInfo;
import com.nagarro.microservices.providerService.model.ServiceRequestInfo;
import com.nagarro.microservices.providerService.service.ProviderService;

@Service
public class ProviderServiceImpl implements ProviderService {

	@Resource
	ProviderDao providerDao;
	
	@Autowired 
	private JmsTemplate jmsTemplate;
	
	@Override
	public Provider getProviderDetails(String id) {
		
		return providerDao.getProviderDetails(id);
	}

	@Override
	public Map<String, String> getAllServices() {
		
		return providerDao.getAllServices();
	}

	@Override
	public ServiceInfo getServiceDetails(String id) {
		
		return providerDao.getServiceDetails(id);
	}

	@Override
	@JmsListener(destination="OrderServiceRequest")
	public void isServiceAvaialbleForOrder(String test) {
		ServiceRequestInfo info = new ServiceRequestInfo();
		info.setOrderId(test.split("-")[0]);
		info.setServiceId(test.split("-")[1]);
		ServiceInfo service = providerDao.getServiceDetails(info.getServiceId());
		if(service.getAvailability().equals(AvailabilityStatus.AVAILABLE)) {
			ServiceAvaliableForOrderEvent(info.getOrderId());
		} else {
			ServiceNotAvaliableForOrderEvent(info.getOrderId());
		}

	}
	
	public void ServiceAvaliableForOrderEvent(String orderID){
		jmsTemplate.convertAndSend("ServiceAvaliableForOrderEvent", orderID);
	}
	
	public void ServiceNotAvaliableForOrderEvent(String orderID){
		jmsTemplate.convertAndSend("ServiceNotAvaliableForOrderEvent", orderID);
	}


	@Override
	public Provider getProviderForService(String serviceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Provider addProvider(Provider provider) {
		return providerDao.addProvider(provider);
	}

	@Override
	public ServiceInfo registerService(ServiceInfo service) {
		return providerDao.registerService(service);
	}

}
