package ui.controller.initializer.search;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.controller.initializer.detail.BuyDetailInitializer;
import ui.view.swing.component.search.BuySearchPanel;
import ui.view.swing.component.search.StandardSearchDialog;
import ui.view.swing.component.search.StandardSearchPanel;

public class BuysDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		addShowCreatingAction(new BuyDetailInitializer(), searchDialog);
		addShowViewingAction(new BuyDetailInitializer(), searchDialog);
	}

	protected StandardSearchPanel searchPanel() {
		return new BuySearchPanel();
	}

	protected SearchQuery searchQuery() {
		return QueryFactory.instance().buySearchQuery();
	}

	protected MessageId titleMessageId() {
		return MessageId.buys;
	}

}
