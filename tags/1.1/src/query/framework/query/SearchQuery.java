package query.framework.query;

import query.framework.criteria.Criteria;
import query.framework.results.SearchResults;


public interface SearchQuery extends Query {

	SearchResults results();

	void setCriteria(Criteria criteria);
}
