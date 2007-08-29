package query.framework.results;

import com.db4o.ObjectSet;

public class Db4oObjectSetSearchResults extends LazySearchResults {

	private final ObjectSet objectSet;

	public Db4oObjectSetSearchResults(LazySearchResultsSpecification spec, ObjectSet objectSet) {
		super(spec);
		this.objectSet = objectSet;
	}

	public Object get(int row) {
		return objectSet.get(row);
	}

	public int getRowCount() {
		return objectSet.size();
	}

}
