package model.stock;

import message.MessageId;
import validation.ModelValidation;


public class Article {

//	private String code;
	private String name;
//	private String size;
	private ArticleGroup group;

	public Article(String description) {
		this(description, null);
		//TODO Implement NullArticleGroup?
	}
	
	public Article(String name, ArticleGroup group) {
//	public Article(String code, String name, String size, ArticleGroup group) {
//		this.code = code;
		this.setName(name);
//		this.size = size;
		this.setGroup(group);
	}
//
//	public String getCode() {
//		return code;
//	}
//
//	public void setCode(String code) {
//		this.code = code;
//	}

	public ArticleGroup getGroup() {
		return group;
	}

	public void setGroup(ArticleGroup group) {
		ModelValidation.instance().assertNotNull(group, MessageId.articleGroup);
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		ModelValidation.instance().assertNotBlank(name, MessageId.name);
		this.name = name;
	}

//	public String getSize() {
//		return size;
//	}
//
//	public void setSize(String size) {
//		this.size = size;
//	}
	
	public String toString() {
//		return getCode() + " - " + getName() + " x " + getSize();
		return getName();
	}

}
