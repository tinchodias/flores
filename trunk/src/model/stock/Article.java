package model.stock;

public class Article {

	private final String description;
	private final String code;
	private final ArticleGroup group;

	public Article(String code, String description) {
		this(code, description, null);
		//TODO Implementar NullArticleGroup?
	}
	
	public Article(String code, String description, ArticleGroup group) {
		this.code = code;
		this.description = description;
		this.group = group;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public ArticleGroup getGroup() {
		return group;
	}

	@Override
	public String toString() {
		return getCode() + " - " + getDescription();
	}
	
}
