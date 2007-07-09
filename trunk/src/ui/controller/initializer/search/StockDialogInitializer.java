package ui.controller.initializer.search;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.controller.initializer.detail.StockArticleDetailInitializer;
import ui.controller.populator.ArticlePopulator;
import ui.view.swing.component.StandardSearchDialog;
import ui.view.swing.component.StandardSearchPanel;
import ui.view.swing.component.StockArticleSearchPanel;

public class StockDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		addShowCreatingAction(new StockArticleDetailInitializer(), new ArticlePopulator(), searchDialog);
		addShowAndRefreshAction(new BuysDialogInitializer(), MessageId.buys, searchDialog);
		addShowAndRefreshAction(new StockDropOutsDialogInitializer(), MessageId.stockDropOuts, searchDialog);
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
