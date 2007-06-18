package model;

import model.address.Address;

public class JuridicPerson {

	private String name;
	private Address address;

	public JuridicPerson(String name, Address address) {
		this.name = name;
		this.address = address;
	}

	public JuridicPerson(String name) {
		this(name, null);
		//TODO Remove this constructor, or remove the null...
	}

	public String getName() {
		return name;
	}

	public void setName(String nombre) {
		this.name = nombre;
	}

	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String toString() {
		return getName();
	}

	
}
