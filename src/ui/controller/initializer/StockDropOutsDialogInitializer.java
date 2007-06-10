package ui.controller.initializer;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.controller.action.ShowDialogAction;
import ui.view.swing.component.StandardSearchDialog;
import ui.view.swing.component.StandardSearchPanel;
import ui.view.swing.component.StockDropOutSearchPanel;

public class StockDropOutsDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		searchDialog.add(new ShowDialogAction(new CreateStockDropOutDialogInitializer(), MessageId.create));
	}

	protected StandardSearchPanel searchPanel() {
		return new StockDropOutSearchPanel();
	}

	protected SearchQuery searchQuery() {
		return QueryFactory.instance().stockDropOutSearchQuery();
	}

	protected MessageId titleMessageId() {
		return MessageId.stockDropOutsDialogTitle;
	}

}
