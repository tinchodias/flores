package ui.view.component;

import query.framework.criteria.Criteria;
import query.framework.results.SearchResults;
import ui.controller.action.Action;

public interface SearchUI {

	public Criteria getCriteria();

	public void setResults(SearchResults results);

	public SearchResults getResults();

	public void setSearchAction(Action action);

	public Action getSearchAction();

	public Object getSelection();
	
	public void add(Action action);
	
	public void setDefaultAction(Action action);
	
}
