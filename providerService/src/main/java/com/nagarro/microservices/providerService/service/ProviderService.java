package com.nagarro.microservices.providerService.service;

import java.util.Map;

import com.nagarro.microservices.providerService.model.Provider;
import com.nagarro.microservices.providerService.model.ServiceInfo;

public interface ProviderService {

	Provider getProviderDetails(String id);

	Map<String, String> getAllServices();

	ServiceInfo getServiceDetails(String id);

}
