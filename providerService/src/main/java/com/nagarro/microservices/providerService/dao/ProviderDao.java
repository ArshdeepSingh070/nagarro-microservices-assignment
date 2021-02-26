package com.nagarro.microservices.providerService.dao;

import java.util.Map;

import com.nagarro.microservices.providerService.model.Provider;
import com.nagarro.microservices.providerService.model.ServiceInfo;

public interface ProviderDao {
	
	Provider getProviderDetails(String id);
	
	ServiceInfo getServiceDetails(String id);
	
	Map<String, String> getAllServices();
	

}
