package ui.controller.initializer.search;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.controller.initializer.detail.CreateStockDropOutDialogInitializer;
import ui.view.swing.component.StandardSearchDialog;
import ui.view.swing.component.StandardSearchPanel;
import ui.view.swing.component.StockDropOutSearchPanel;

public class StockDropOutsDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		addShowAndRefreshAction(new CreateStockDropOutDialogInitializer(), MessageId.create, searchDialog);
	}

	protected StandardSearchPanel searchPanel() {
		return new StockDropOutSearchPanel();
	}

	protected SearchQuery searchQuery() {
		return QueryFactory.instance().stockDropOutSearchQuery();
	}

	protected MessageId titleMessageId() {
		return MessageId.stockDropOuts;
	}

}
