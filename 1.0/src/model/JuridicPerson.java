package model;

import message.MessageId;
import model.address.Address;
import validation.ModelValidation;

public class JuridicPerson {

	private String name;
	private Address address;

	public JuridicPerson(String name, Address address) {
		setName(name);
		setAddress(address);
	}

	/**
	 * @deprecated
	 */
	public JuridicPerson(String name) {
		this(name, null);
		//TODO Remove this constructor, or remove the null...
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		ModelValidation.instance().assertNotBlank(name, MessageId.clientName);
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		ModelValidation.instance().assertNotNull(address, MessageId.address);
		this.address = address;
	}
	
	public String toString() {
		return getName();
	}
	
}
