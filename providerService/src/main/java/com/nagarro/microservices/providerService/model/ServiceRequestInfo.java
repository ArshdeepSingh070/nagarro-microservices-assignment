package com.nagarro.microservices.providerService.model;

public class ServiceRequestInfo {

	private String orderId;
	private String serviceId;
	
	public ServiceRequestInfo() {
		
	}

	public ServiceRequestInfo(String orderId, String serviceId) {
		super();
		this.orderId = orderId;
		this.serviceId = serviceId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	
	
}
