package model;

import model.address.Address;

import org.apache.commons.lang.StringUtils;

public class JuridicPerson {

	private String name;
	private Address address;

	public JuridicPerson(String name, Address address) {
		//TODO!
		if (StringUtils.isBlank(name)) {
			throw new RuntimeException("Nombre incorrecto");
		}
		
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

	public int hashCode() {
		//FIXME
		return toString().hashCode();
	}
	
	public boolean equals(Object obj) {
		//FIXME
		if (obj != null && obj instanceof JuridicPerson) {
			JuridicPerson a = (JuridicPerson) obj;
			return this.toString().equals(a.toString());
		}
		return false;
	}
	
	
}
