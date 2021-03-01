package com.nagarro.microservices.userService.models;

public class Service {

	private String id;
	private String name;
	private String description;
	private AvailabilityInfo availability;
	
	public Service() {
		
	}
	
	public Service(String id, String name, String description, AvailabilityInfo availability) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.availability = availability;
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

	public AvailabilityInfo getAvailability() {
		return availability;
	}

	public void setAvailability(AvailabilityInfo availability) {
		this.availability = availability;
	}


	
	
}
