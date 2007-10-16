package ui.controller.manager;

import message.MessageId;
import model.Store;
import persistence.ModelPersistence;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.controller.initializer.search.SearchDialogInitializer;
import ui.controller.initializer.search.StandardSearchDialogInitializer;

public class StandardUIModelManager implements UIModelManager {

	private final SearchDialogInitializer searchInitializer;
	private final SearchQuery stringSearchQuery;
	private final MessageId pluralNameMessageId;

	public StandardUIModelManager(StandardSearchDialogInitializer searchInitializer, Iterable items) {
		this(searchInitializer, items, searchInitializer.titleMessageId());
	}
	
	public StandardUIModelManager(SearchDialogInitializer searchInitializer, Iterable items, MessageId pluralNameMessageId) {
		this.searchInitializer = searchInitializer;
		this.stringSearchQuery = QueryFactory.instance().stringSearchQuery(items);
		this.pluralNameMessageId = pluralNameMessageId;
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

	public MessageId pluralNameMessageId() {
		return pluralNameMessageId;
	}
	
}
