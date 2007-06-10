package query;

import model.JuridicPerson;
import model.stock.Article;
import model.stock.StockDropOut;
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

	public abstract SearchQuery<JuridicPerson> clientSearchQuery();

	public abstract SearchQuery<Article> stockArticleSearchQuery();
	
	public abstract SearchQuery<StockDropOut> stockDropOutSearchQuery();
}