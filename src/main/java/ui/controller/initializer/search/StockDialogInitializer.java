package ui.controller.initializer.search;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.controller.initializer.detail.StockArticleDetailInitializer;
import ui.view.swing.component.search.StandardSearchDialog;
import ui.view.swing.component.search.StandardSearchPanel;
import ui.view.swing.component.search.StockArticleSearchPanel;

public class StockDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		addShowCreatingAction(new StockArticleDetailInitializer(), searchDialog);
		addShowModifyingAction(new StockArticleDetailInitializer(), searchDialog);
	}

	protected StandardSearchPanel searchPanel() {
		return new StockArticleSearchPanel();
	}

	public SearchQuery searchQuery() {
		return QueryFactory.instance().stockArticleSearchQuery();
	}

	public MessageId titleMessageId() {
		return MessageId.stockDialogTitle;
	}

}
