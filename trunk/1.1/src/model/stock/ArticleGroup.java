package model.stock;

import message.MessageId;
import validation.ModelValidation;

public class ArticleGroup {

	private String name;

	public ArticleGroup(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		ModelValidation.instance().assertNotBlank(name, MessageId.name);
		this.name = name;
	}
	
	@Override
	public String toString() {
		return getName();
	}

}
