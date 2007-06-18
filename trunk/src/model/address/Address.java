package model.address;

public class Address {

	private String address;
	private City city;
	
	public Address(String address, City city) {
		this.address = address;
		this.city = city;
	}

	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public City getCity() {
		return city;
	}
	
	public void setCity(City city) {
		this.city = city;
	}
	
	public String toString() {
		return getAddress() + ", " + getCity();
	}
	
}
