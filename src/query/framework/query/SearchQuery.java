package query.framework.query;

import query.framework.criteria.Criteria;
import query.framework.results.SearchResults;


public interface SearchQuery<T> extends Query {

	SearchResults<T> results();

	void setCriteria(Criteria criteria);
}
