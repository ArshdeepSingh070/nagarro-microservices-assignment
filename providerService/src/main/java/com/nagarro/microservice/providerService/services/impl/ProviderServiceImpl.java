package com.nagarro.microservice.providerService.services.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nagarro.microservice.providerService.dao.ProviderDao;
import com.nagarro.microservice.providerService.models.Provider;
import com.nagarro.microservice.providerService.models.ServiceInfo;
import com.nagarro.microservice.providerService.services.ProviderService;

@Service
public class ProviderServiceImpl implements ProviderService {

	
	@Resource
	ProviderDao providerDao;
	
	@Override
	public Provider getProviderDetails(String id) {
		return providerDao.findProvider(id);
	}

	@Override
	public Map<String, String> getAllServices() {

		return providerDao.getAllServices();
	}

	@Override
	public ServiceInfo getServiceDetails(String id) {
		
		return null;
	}

}
