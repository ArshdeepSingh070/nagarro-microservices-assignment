package com.nagarro.microservices.providerService.serviceimpl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nagarro.microservices.providerService.dao.ProviderDao;
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

}
