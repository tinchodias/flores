package model.address;

import message.MessageId;
import validation.ModelValidation;

public class Province {

	private String name;

	public Province(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		ModelValidation.instance().assertNotBlank(name, MessageId.name);
		this.name = name;
	}

	public String toString() {
		return getName();
	}
	
}
