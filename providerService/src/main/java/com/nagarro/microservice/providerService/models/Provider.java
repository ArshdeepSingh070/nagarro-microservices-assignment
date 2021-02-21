package com.nagarro.microservice.providerService.models;

public class Provider {

	private String id;
	private String name;
	private String gender;
	private String profession;
	private String phoneNo;

	public Provider(String id, String name, String gender, String profession, String phoneNo) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.profession = profession;
		this.phoneNo = phoneNo;
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

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}
