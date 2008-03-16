package ui.view.component;

import java.util.List;

import query.framework.criteria.Criteria;
import query.framework.results.SearchResults;
import ui.controller.action.Action;

public interface SearchUI {

	Criteria getCriteria();

	void setResults(SearchResults results);

	SearchResults getResults();

	void setSearchAction(Action action);

	Action getSearchAction();

	Object getSelection();

	List getSelections();
	
	void add(Action action);
	
	void setDefaultAction(Action action);
	
}
