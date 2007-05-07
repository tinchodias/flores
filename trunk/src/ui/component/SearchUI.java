package ui.component;

import query.framework.criteria.Criteria;
import query.framework.results.Results;

public interface SearchUI {

	public Criteria criteria();

	public void setResults(Results results);

}
