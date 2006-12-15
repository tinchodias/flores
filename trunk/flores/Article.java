package flores;

public class Article {

	private final String description;
	private final String code;

	public Article(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

}
