package com.nagarro.microservice.providerService.services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.nagarro.microservice.providerService.models.Provider;
import com.nagarro.microservice.providerService.models.ServiceInfo;

public interface ProviderService {

	Provider getProviderDetails(String id);
	
	Map<String, String> getAllServices();
	
	ServiceInfo getServiceDetails(String id);
}
