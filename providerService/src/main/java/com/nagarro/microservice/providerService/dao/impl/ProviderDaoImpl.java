package com.nagarro.microservice.providerService.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.nagarro.microservice.providerService.dao.ProviderDao;
import com.nagarro.microservice.providerService.models.ServiceInfo;
import com.nagarro.microservice.providerService.models.Provider;

@Component
public class ProviderDaoImpl implements ProviderDao {

	@Override
	public Provider findProvider(String id) {
		List<Provider> providers = allStoredProviders();

		Optional<Provider> reqProvider = providers.stream().filter(pro -> id.equals(pro.getId())).findAny();

		return reqProvider.get();
	}

	@Override
	public ServiceInfo findService(String id) {
		List<ServiceInfo> servicesList = allServices();
		Optional<ServiceInfo> reqService = servicesList.stream().filter(ser -> id.equals(ser.getId())).findFirst();
		return reqService.get();
	}

	@Override
	public Map<String, String> getAllServices() {
		List<ServiceInfo> servicesList = allServices();
		Map<String, String> servicesDetails = new HashMap<>();
		for (ServiceInfo ser : servicesList) {
			servicesDetails.put(ser.getId(), ser.getName());
		}
		return servicesDetails;
	}

	protected List<Provider> allStoredProviders() {

		List<Provider> providersList = new ArrayList<>();

		providersList.add(new Provider("001", "xyz", "male", null, "78594778998"));

		return providersList;
	}

	protected List<ServiceInfo> allServices() {
		List<ServiceInfo> servicesList = new ArrayList<>();
		servicesList.add(new ServiceInfo("001", "Mechanic", "Repair cars and bikes"));
		servicesList.add(new ServiceInfo("002", "Electrician", "Repair electronic gadets"));
		servicesList.add(new ServiceInfo("001", "hair dresser", "hair dressing"));
		return servicesList;
	}

}
