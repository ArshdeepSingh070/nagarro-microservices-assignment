package com.nagarro.microservices.providerService.model;

public class ServiceInfo {

	private String id;
	private String name;
	private String description;
	private AvailabilityStatus availability;
	private Provider providerInfo;

	public ServiceInfo(String id, String name, String description, AvailabilityStatus availability,
			Provider providerInfo) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.availability = availability;
		this.providerInfo = providerInfo;
	}


	public Provider getProviderInfo() {
		return providerInfo;
	}


	public void setProviderInfo(Provider providerInfo) {
		this.providerInfo = providerInfo;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public AvailabilityStatus getAvailability() {
		return availability;
	}


	public void setAvailability(AvailabilityStatus availability) {
		this.availability = availability;
	}

	
}
