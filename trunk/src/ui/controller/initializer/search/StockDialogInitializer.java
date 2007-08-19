package ui.controller.initializer.search;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.controller.initializer.detail.StockArticleDetailInitializer;
import ui.controller.populator.ArticlePopulator;
import ui.view.swing.component.search.StandardSearchDialog;
import ui.view.swing.component.search.StandardSearchPanel;
import ui.view.swing.component.search.StockArticleSearchPanel;

public class StockDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		addShowCreatingAction(new StockArticleDetailInitializer(), new ArticlePopulator(), searchDialog);
		addShowModifyingAction(new StockArticleDetailInitializer(), new ArticlePopulator(), searchDialog);
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
