package com.nagarro.microservices.providerService.model;

public class Provider {

	private String id;
	private String name;
	private String gender;
	private String serviceId;
	private String serviceName;
	private String phoneNo;
	private AvailabilityStatus currentStatus;
	
	public Provider() {
		
	}
	
	
	public Provider(String id, String name, String gender, String serviceId, String serviceName, String phoneNo,
			AvailabilityStatus currentStatus) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.phoneNo = phoneNo;
		this.currentStatus = currentStatus;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public AvailabilityStatus getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(AvailabilityStatus currentStatus) {
		this.currentStatus = currentStatus;
	}


	public String getServiceName() {
		return serviceName;
	}


	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	
	
}
