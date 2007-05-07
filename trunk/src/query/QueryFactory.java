package query;

import model.JuridicPerson;
import query.criteria.ClientSearchCriteria;
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

	public abstract SearchQuery<JuridicPerson> clientSearchQuery(ClientSearchCriteria criteria);
	
}
