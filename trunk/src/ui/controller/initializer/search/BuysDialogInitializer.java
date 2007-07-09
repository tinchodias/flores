package ui.controller.initializer.search;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.controller.initializer.detail.CreateBuyDialogInitializer;
import ui.view.swing.component.BuySearchPanel;
import ui.view.swing.component.StandardSearchDialog;
import ui.view.swing.component.StandardSearchPanel;

public class BuysDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		addShowAndRefreshAction(new CreateBuyDialogInitializer(), MessageId.create, searchDialog);
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
