package com.nagarro.microservices.providerService.daoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.nagarro.microservices.providerService.dao.ProviderDao;
import com.nagarro.microservices.providerService.model.AvailabilityStatus;
import com.nagarro.microservices.providerService.model.Provider;
import com.nagarro.microservices.providerService.model.ServiceInfo;

@Component
public class ProviderDaoImpl implements ProviderDao {

	@Override
	public Provider getProviderDetails(String id) {
		List<Provider> providers = allStoredProviders();

		Optional<Provider> reqProvider = providers.stream().filter(pro -> id.equals(pro.getId())).findAny();

		return reqProvider.get();
	}

	@Override
	public ServiceInfo getServiceDetails(String id) {
		List<ServiceInfo> servicesList = allServices();
		Optional<ServiceInfo> reqService = servicesList.stream().filter(ser -> id.equals(ser.getId())).findFirst();
		return reqService.get();
	}

	@Override
	public List<Provider> getProvidersForServiec(String serviceId) {
		List<Provider> providerList = allStoredProviders();
		List<Provider> requiredProviders = (List<Provider>) providerList.stream()
				.filter(pl -> serviceId.equals(pl.getServiceId()));

		return requiredProviders;
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

		providersList.add(new Provider("001", "xyz", "male", "001", "78594778998", AvailabilityStatus.AVAILABLE));

		return providersList;
	}

	// Sudo service info for demo
	protected List<ServiceInfo> allServices() {
		List<ServiceInfo> servicesList = new ArrayList<>();
		servicesList.add(new ServiceInfo("001", "Mechanic", "Repair cars and bikes"));
		servicesList.add(new ServiceInfo("002", "Electrician", "Repair electronic gadets"));
		servicesList.add(new ServiceInfo("003", "hair dresser", "Hair dressing"));
		return servicesList;
	}

}
