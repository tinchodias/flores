package ui.controller.manager;

import model.Store;
import persistence.ModelPersistence;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.controller.initializer.search.SearchDialogInitializer;

public class StandardUIModelManager implements UIModelManager {

	private SearchDialogInitializer searchInitializer;
	private SearchQuery stringSearchQuery;

	public StandardUIModelManager(SearchDialogInitializer searchInitializer, Iterable items) {
		this.searchInitializer = searchInitializer;
		this.stringSearchQuery = QueryFactory.instance().stringSearchQuery(items);
	}

	public SearchDialogInitializer searchInitializer() {
		return searchInitializer;
	}

	public SearchQuery stringSearchQuery() {
		return stringSearchQuery;
	}

	protected static Store store() {
		return ModelPersistence.instance().loadedModel().store();
	}
	
}
