package ui.controller.initializer.search;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.view.swing.component.search.CitySearchPanel;
import ui.view.swing.component.search.StandardSearchDialog;
import ui.view.swing.component.search.StandardSearchPanel;

public class CitiesDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
	}

	protected StandardSearchPanel searchPanel() {
		return new CitySearchPanel();
	}

	public SearchQuery searchQuery() {
		return QueryFactory.instance().citySearchQuery();
	}

	public MessageId titleMessageId() {
		return MessageId.cities;
	}

}
