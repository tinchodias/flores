package query;

import query.framework.query.SearchQuery;
import query.implementation.db4o.Db4oQueryFactory;

public abstract class QueryFactory {

	private static QueryFactory instance;

	public static QueryFactory instance() {
		if (instance == null) {
			instance = new Db4oQueryFactory();
		}
		return instance;
	}
	
	public static void instance(QueryFactory queryFactory) {
		instance = queryFactory;
	}

	public abstract SearchQuery clientSearchQuery();

	public abstract SearchQuery stockArticleSearchQuery();
	
	public abstract SearchQuery pricePercentageSearchQuery();
	
	public abstract SearchQuery stockDropOutSearchQuery();

	public abstract SearchQuery buySearchQuery();

	public abstract SearchQuery citySearchQuery();

	public abstract SearchQuery suppliersSearchQuery();

	public abstract SearchQuery sellSearchQuery();

	public abstract SearchQuery articleGroupSearchQuery();

	public abstract SearchQuery stringSearchQuery(Iterable items);

	public abstract SearchQuery cashBookEntrySearchQuery();

	public abstract SearchQuery expensesArticlesSearchQuery();

	public abstract SearchQuery expensesSearchQuery();

	public abstract SearchQuery cashExtractionsSearchQuery();

	public abstract SearchQuery clientDebtCancellationsSearchQuery();

	public abstract SearchQuery clientMovementsQuery();

	public abstract SearchQuery lostDebtDeclarationsSearchQuery();
	
}
