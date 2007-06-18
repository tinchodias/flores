package model.stock;

public class Article {

	private final String description;
	private final ArticleGroup group;

	public Article(String description) {
		this(description, null);
		//TODO Implementar NullArticleGroup?
	}
	
	public Article(String description, ArticleGroup group) {
		this.description = description;
		this.group = group;
	}

	public String getDescription() {
		return description;
	}

	public ArticleGroup getGroup() {
		return group;
	}

	public String toString() {
		return getDescription();
	}
	
}
