package com.nagarro.microservices.providerService.daoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.nagarro.microservices.providerService.dao.ProviderDao;
import com.nagarro.microservices.providerService.model.AvailabilityStatus;
import com.nagarro.microservices.providerService.model.Provider;
import com.nagarro.microservices.providerService.model.ServiceInfo;

@Component
public class ProviderDaoImpl implements ProviderDao {

	private Map<String, Provider> providers = new HashMap<>();
	
	private Map<String, ServiceInfo> services = new HashMap<>();
	
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
		if(!isServiceAvailable(reqService.get())) {
			reqService.get().setAvailability(AvailabilityStatus.NOTAVAILABLE);
		}
		return reqService.get();
	}

	@Override
	public List<Provider> getProvidersForServiec(String serviceId) {
		List<Provider> providerList = allStoredProviders();
		List<Provider> requiredProviders = providerList.stream().filter(reqPro -> 
		serviceId.equals(reqPro.getServiceId())).collect(Collectors.toList());

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
	
	@Override
	public Provider addProvider(Provider provider) {
		provider.setCurrentStatus(AvailabilityStatus.AVAILABLE);
		providers.put(provider.getId(), provider);
		return providers.get(provider.getId());
	
	}
	
	@Override
	public ServiceInfo registerService(ServiceInfo service) {
		service.setAvailability(AvailabilityStatus.AVAILABLE);
		services.put(service.getId(), service);
		return services.get(service.getId());
	}

	
	protected Boolean isServiceAvailable(ServiceInfo service) {
		List<Provider> providers = getProvidersForServiec(service.getId());
		int count = 0;
		for(Provider pro : providers) {
			if(pro.getCurrentStatus().equals(AvailabilityStatus.AVAILABLE)) {
				service.setProviderInfo(pro);
				break;
			}else {
				count++;
			}
		}
		if(count == providers.size()) {
			return false;
		}
		return true;
	}

	// Sudo Provider info for demo purpose only
	protected List<Provider> allStoredProviders() {

		List<Provider> providersList = new ArrayList<>();

		providersList.add(new Provider("001", "xyz", "male", "101", "mechanic", "9918278768", AvailabilityStatus.AVAILABLE));

		return providersList;
	}

	// Sudo service info for demo purpose only
	protected List<ServiceInfo> allServices() {
		List<ServiceInfo> servicesList = new ArrayList<>();
		servicesList.add(new ServiceInfo("101", "Mechanic", "Repair cars and bikes", AvailabilityStatus.AVAILABLE, null));
		servicesList.add(new ServiceInfo("102", "Electrician", "Repair electronic gadets", AvailabilityStatus.AVAILABLE, null));
		servicesList.add(new ServiceInfo("103", "hair dresser", "Hair dressing", AvailabilityStatus.AVAILABLE, null));
		return servicesList;
	}

	
	

}
