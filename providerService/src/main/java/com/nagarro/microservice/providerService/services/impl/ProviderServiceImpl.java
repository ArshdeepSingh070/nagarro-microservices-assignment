package com.nagarro.microservice.providerService.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nagarro.microservice.providerService.dao.ProviderDao;
import com.nagarro.microservice.providerService.models.Provider;
import com.nagarro.microservice.providerService.services.ProviderService;

@Service
public class ProviderServiceImpl implements ProviderService {

	
	@Resource
	ProviderDao providerDao;
	
	@Override
	public Provider getProviderDetails(String id) {
		return providerDao.findProvider(id);
	}

}
