package query;

import query.criteria.ClientSearchCriteria;
import query.natives.NativeQueryFactory;

public abstract class QueryFactory {

	private static QueryFactory instance;

	public static QueryFactory instance() {
		if (instance == null) {
			instance = new NativeQueryFactory();
		}
		return instance;
	}

	public abstract Query clientSearchQuery(ClientSearchCriteria criteria);
	
}
