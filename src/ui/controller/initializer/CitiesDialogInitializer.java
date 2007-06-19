package ui.controller.initializer;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.view.swing.component.CitySearchPanel;
import ui.view.swing.component.StandardSearchDialog;
import ui.view.swing.component.StandardSearchPanel;

public class CitiesDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
	}

	protected StandardSearchPanel searchPanel() {
		return new CitySearchPanel();
	}

	protected SearchQuery searchQuery() {
		return QueryFactory.instance().citySearchQuery();
	}

	protected MessageId titleMessageId() {
		return MessageId.citiesDialogTitle;
	}

}
