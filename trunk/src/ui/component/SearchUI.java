package ui.component;

import query.criteria.Criteria;
import query.results.Results;

public interface SearchUI {

	public Criteria criteria();

	public void setResults(Results results);

}
