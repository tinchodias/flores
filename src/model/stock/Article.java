package model.stock;

public class Article {

	private final String name;
	private final ArticleGroup group;

	public Article(String description) {
		this(description, null);
		//TODO Implementar NullArticleGroup?
	}
	
	public Article(String description, ArticleGroup group) {
		this.name = description;
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public ArticleGroup getGroup() {
		return group;
	}

	public String toString() {
		return getName();
	}
	
}
