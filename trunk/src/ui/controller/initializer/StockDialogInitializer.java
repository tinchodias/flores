package ui.controller.initializer;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.controller.action.Action;
import ui.controller.action.ShowDialogAction;
import ui.view.swing.component.StandardSearchDialog;
import ui.view.swing.component.StandardSearchPanel;
import ui.view.swing.component.StockArticleSearchPanel;

public class StockDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		Action showBuysDialogAction = new ShowDialogAction(new BuysDialogInitializer(), MessageId.buysDialogTitle);
		Action showStockDropDownsAction = new ShowDialogAction(new StockDropOutsDialogInitializer(), MessageId.stockDropOutsDialogTitle);

		searchDialog.add(showBuysDialogAction);
		searchDialog.add(showStockDropDownsAction);
	}

	protected StandardSearchPanel searchPanel() {
		return new StockArticleSearchPanel();
	}

	protected SearchQuery searchQuery() {
		return QueryFactory.instance().stockArticleSearchQuery();
	}

	protected MessageId titleMessageId() {
		return MessageId.stockDialogTitle;
	}

}
