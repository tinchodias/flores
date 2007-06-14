package ui.controller.initializer;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.controller.action.ShowDialogAction;
import ui.view.swing.component.BuySearchPanel;
import ui.view.swing.component.StandardSearchDialog;
import ui.view.swing.component.StandardSearchPanel;

public class BuysDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		searchDialog.add(new ShowDialogAction(new CreateBuyDialogInitializer(), MessageId.create));
	}

	protected StandardSearchPanel searchPanel() {
		return new BuySearchPanel();
	}

	protected SearchQuery searchQuery() {
		return QueryFactory.instance().buySearchQuery();
	}

	protected MessageId titleMessageId() {
		return MessageId.buysDialogTitle;
	}

}