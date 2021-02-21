package com.nagarro.microservice.providerService.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.nagarro.microservice.providerService.dao.ProviderDao;
import com.nagarro.microservice.providerService.models.Provider;

@Component
public class ProviderDaoImpl implements ProviderDao {

	@Override
	public Provider findProvider(String id) {
		List<Provider> providers = allStoredProviders();

		Optional<Provider> reqProvider = providers.stream().filter(pro -> id.equals(pro.getId())).findAny();

		return reqProvider.get();
	}
	
	protected List<Provider> allStoredProviders() {

		List<Provider> providersList = new ArrayList<>();

		providersList.add(new Provider("001", "abc", "yoga instructor", "male", "83789678977"));
		providersList.add(new Provider("002", "xyz", "car mechanic", "male", "83789678989"));
		providersList.add(new Provider("003", "mno", "electrician", "male", "83789678897"));
		providersList.add(new Provider("004", "pqr", "hair dresser", "female", "83789678787"));

		return providersList;
	}

}
