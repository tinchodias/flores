package query.framework.results;


public interface SearchResults extends Results, Iterable {

	public abstract Object get(int row);
	
}
