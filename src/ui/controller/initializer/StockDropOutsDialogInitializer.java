package ui.controller.initializer;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.view.swing.component.StandardSearchDialog;
import ui.view.swing.component.StandardSearchPanel;
import ui.view.swing.component.StockDropOutSearchPanel;

public class StockDropOutsDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		searchDialog.getSearchPanel().add(showAndRefreshAction(new CreateStockDropOutDialogInitializer(), MessageId.create, searchDialog));
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
