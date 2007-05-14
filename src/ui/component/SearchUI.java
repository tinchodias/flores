package ui.component;

import query.framework.criteria.Criteria;
import query.framework.results.SearchResults;

public interface SearchUI {

	public Criteria criteria();

	public void setResults(SearchResults results);

	public Object selection();
	
}
