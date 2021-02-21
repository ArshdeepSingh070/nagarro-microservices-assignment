package com.nagarro.microservice.providerService.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.nagarro.microservice.providerService.models.Provider;
import com.nagarro.microservice.providerService.models.ServiceInfo;

public interface ProviderDao {

	Provider findProvider(String id);
	
	ServiceInfo findService(String id);

	Map<String, String> getAllServices();
}
