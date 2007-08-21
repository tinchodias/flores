package query.framework.results;

import java.util.List;

import model.util.CollectionFactory;


public class DefaultLazySearchResults extends LazySearchResults {

	private List sources = CollectionFactory.newList();

	public DefaultLazySearchResults(LazySearchResultsSpecification spec) {
		super(spec);
	}
	
	public void add(Object object) {
		this.sources.add(object);
	}

	public boolean remove(Object object) {
		return this.sources.remove(object);
	}
	
	public int getRowCount() {
		return sources.size();
	}

	public Object get(int index) {
		return sources.get(index);
	}

}
