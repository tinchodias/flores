package model.address;

import message.MessageId;
import validation.ModelValidation;

public class Address {

	private String address;
	private City city;
	
	public Address(String address, City city) {
		this.setAddress(address);
		this.setCity(city);
	}

	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		ModelValidation.instance().assertNotBlank(address, MessageId.address);
		this.address = address;
	}
	
	public City getCity() {
		return city;
	}
	
	public void setCity(City city) {
		ModelValidation.instance().assertNotNull(city, MessageId.city);
		this.city = city;
	}
	
	public String toString() {
		return getAddress() + ", " + getCity();
	}
	
}
