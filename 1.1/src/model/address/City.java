package model.address;

import message.MessageId;
import validation.ModelValidation;

public class City {

	private String name;
	private Province province;

	public City(String name, Province province) {
		this.setName(name);
		this.setProvince(province);
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		ModelValidation.instance().assertNotBlank(name, MessageId.name);
		this.name = name;
	}
	
	public Province getProvince() {
		return province;
	}
	
	public void setProvince(Province province) {
		ModelValidation.instance().assertNotNull(province, MessageId.province);
		this.province = province;
	}
	
	public String toString() {
		return getName(); 
	}
	
}
