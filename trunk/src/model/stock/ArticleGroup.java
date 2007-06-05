package model.stock;

public class ArticleGroup {

	private final String name;

	public ArticleGroup(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return getName();
	}
	
}
