package query.framework.query;

import query.framework.results.SearchResults;


public interface SearchQuery<T> extends Query {

	public abstract SearchResults<T> results();

}
