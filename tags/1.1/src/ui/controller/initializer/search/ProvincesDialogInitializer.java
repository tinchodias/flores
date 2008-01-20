package ui.controller.initializer.search;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.view.swing.component.search.ProvinceSearchPanel;
import ui.view.swing.component.search.StandardSearchDialog;
import ui.view.swing.component.search.StandardSearchPanel;

public class ProvincesDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
	}

	protected StandardSearchPanel searchPanel() {
		return new ProvinceSearchPanel();
	}

	public SearchQuery searchQuery() {
		return QueryFactory.instance().provinceSearchQuery();
	}

	public MessageId titleMessageId() {
		return MessageId.provinces;
	}

}
