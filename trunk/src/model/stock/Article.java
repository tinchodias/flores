package model.stock;


public class Article {

	private String code;
	private String name;
	private String size;
	private ArticleGroup group;

	public Article(String description) {
		this(description, null);
		//TODO Implement NullArticleGroup?
	}
	
	public Article(String name, ArticleGroup group) {
		this("", name, "", group);
	}

	public Article(String code, String name, String size, ArticleGroup group) {
		this.code = code;
		this.name = name;
		this.size = size;
		this.group = group;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ArticleGroup getGroup() {
		return group;
	}

	public void setGroup(ArticleGroup group) {
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	public String toString() {
		return getName() + " x " + getSize();
	}

	public int hashCode() {
		//FIXME
		return toString().hashCode();
	}
	
	public boolean equals(Object obj) {
		//FIXME
		if (obj != null && obj instanceof Article) {
			Article a = (Article) obj;
			return this.toString().equals(a.toString());
		}
		return false;
	}
}
