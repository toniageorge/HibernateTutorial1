package com.melvin.tonia.hibernate.collections;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AddressDetails {

	@Column(name="CITY_NAME")
	private String city;
	private String state;
	private String pincode;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	

}
