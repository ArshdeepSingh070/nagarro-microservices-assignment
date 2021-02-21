package com.nagarro.microservice.providerService.services;

import com.nagarro.microservice.providerService.models.Provider;

public interface ProviderService {

	Provider getProviderDetails(String id);
}
