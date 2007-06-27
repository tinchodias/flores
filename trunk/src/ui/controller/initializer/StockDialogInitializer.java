package ui.controller.initializer;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.controller.action.Action;
import ui.view.swing.component.StandardSearchDialog;
import ui.view.swing.component.StandardSearchPanel;
import ui.view.swing.component.StockArticleSearchPanel;

public class StockDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		Action showBuysDialogAction = showAndRefreshAction(new BuysDialogInitializer(), MessageId.buys, searchDialog);
		Action showStockDropDownsAction = showAndRefreshAction(new StockDropOutsDialogInitializer(), MessageId.stockDropOuts, searchDialog);
		Action createStockArticleAction = showAndRefreshAction(new CreateStockArticleDialogInitializer(), MessageId.create, searchDialog);

		searchDialog.getSearchPanel().add(showBuysDialogAction);
		searchDialog.getSearchPanel().add(showStockDropDownsAction);
		searchDialog.getSearchPanel().add(createStockArticleAction);
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
