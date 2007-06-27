package query;

import query.framework.query.SearchQuery;
import query.implementation.natives.NativeQueryFactory;

public abstract class QueryFactory {

	private static QueryFactory instance;

	public static QueryFactory instance() {
		if (instance == null) {
			instance = new NativeQueryFactory();
		}
		return instance;
	}

	public abstract SearchQuery clientSearchQuery();

	public abstract SearchQuery stockArticleSearchQuery();
	
	public abstract SearchQuery stockDropOutSearchQuery();

	public abstract SearchQuery buySearchQuery();

	public abstract SearchQuery citySearchQuery();

	public abstract SearchQuery suppliersSearchQuery();

	public abstract SearchQuery sellSearchQuery();

	public abstract SearchQuery articleGroupSearchQuery();
	
}
