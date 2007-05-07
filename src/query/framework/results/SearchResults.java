package query.framework.results;


public interface SearchResults<T> extends Results {

	public abstract T getFoundObject(int rowIndex);
	
}
