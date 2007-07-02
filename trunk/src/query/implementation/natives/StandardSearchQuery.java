package query.implementation.natives;

import model.Store;
import persistence.Model;
import persistence.ModelPersistence;
import query.framework.criteria.Criteria;
import query.framework.query.SearchQuery;
import query.framework.results.DefaultLazySearchResults;
import query.framework.results.LazySearchResults;
import query.framework.results.LazySearchResultsSpecification;
import query.framework.results.SearchResults;

abstract class StandardSearchQuery <GenericType, GenericCriteria extends Criteria> 
	implements SearchQuery {
	
	private GenericCriteria criteria;
	
	public void setCriteria(Criteria criteria) {
		this.criteria = (GenericCriteria) criteria; 
	}
	
	public SearchResults results() {
		Iterable objects = objects();

		LazySearchResults results = new DefaultLazySearchResults(resultsSpecification());
		
		for (Object object : objects) {
			if (accepts((GenericType) object)) {
				results.add(object);
			}
		}
		return results;
	}

	protected GenericCriteria criteria() {
		return criteria;
	}
	
	protected Model model() {
		return ModelPersistence.instance().loadedModel();
	}

	protected Store store() {
		return ModelPersistence.instance().loadedModel().store();
	}
	
	protected abstract boolean accepts(GenericType object);

	protected abstract LazySearchResultsSpecification resultsSpecification();

	protected abstract Iterable objects();
	
}
