package ui.controller.initializer.search;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.controller.initializer.detail.StockDropOutDetailInitializer;
import ui.controller.populator.StockDropOutPopulator;
import ui.view.swing.component.search.StandardSearchDialog;
import ui.view.swing.component.search.StandardSearchPanel;
import ui.view.swing.component.search.StockDropOutSearchPanel;

public class StockDropOutsDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		addShowCreatingAction(new StockDropOutDetailInitializer(), new StockDropOutPopulator(), searchDialog);
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
