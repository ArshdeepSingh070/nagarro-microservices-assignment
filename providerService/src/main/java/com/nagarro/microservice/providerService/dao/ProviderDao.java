package com.nagarro.microservice.providerService.dao;

import com.nagarro.microservice.providerService.models.Provider;

public interface ProviderDao {

	Provider findProvider(String id);
}
