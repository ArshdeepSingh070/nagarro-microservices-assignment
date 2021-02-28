package com.nagarro.microservices.providerService.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nagarro.microservices.providerService.dao.ProviderDao;
import com.nagarro.microservices.providerService.model.AvailabilityStatus;
import com.nagarro.microservices.providerService.model.Provider;
import com.nagarro.microservices.providerService.model.ServiceInfo;
import com.nagarro.microservices.providerService.service.ProviderService;

@Service
public class ProviderServiceImpl implements ProviderService {

	@Resource
	ProviderDao providerDao;
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
	public void isServiceAvaialbleForOrder(String serviceId, String orderId) {
		int availabilityCount = 0;
		List<Provider> providers = providerDao.getProvidersForServiec(serviceId);
		for (Provider provider : providers) {
			if (provider.getCurrentStatus().equals(AvailabilityStatus.AVAILABLE)) {
				availabilityCount++;
			}
		}

		if (availabilityCount > 0) {
			ServiceAvaliableForOrderEvent(orderId);
		} else {
			ServiceNotAvaliableForOrderEvent(orderId);
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

}
