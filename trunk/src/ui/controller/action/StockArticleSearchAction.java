package ui.controller.action;

import query.QueryFactory;
import query.framework.criteria.Criteria;
import query.framework.query.SearchQuery;
import ui.view.component.SearchUI;

public class StockArticleSearchAction implements Action {

	private final SearchUI searchUI;

	public StockArticleSearchAction(SearchUI searchUI) {
		this.searchUI = searchUI;
	}

	public void execute() {
		Criteria criteria = searchUI.criteria();
		
		SearchQuery searchQuery = QueryFactory.instance().stockArticleSearchQuery(criteria);
		
		searchUI.setResults(searchQuery.results());
	}

	public String getTitle() {
		return "Buscar artículos";
	}

}
