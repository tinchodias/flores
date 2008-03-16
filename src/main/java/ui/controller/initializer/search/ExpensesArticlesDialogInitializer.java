package ui.controller.initializer.search;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.controller.initializer.detail.ExpenseArticleDetailInitializer;
import ui.view.swing.component.search.ExpenseArticleSearchPanel;
import ui.view.swing.component.search.StandardSearchDialog;
import ui.view.swing.component.search.StandardSearchPanel;

public class ExpensesArticlesDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		addShowCreatingAction(new ExpenseArticleDetailInitializer(), searchDialog);
		addShowModifyingAction(new ExpenseArticleDetailInitializer(), searchDialog);
	}

	protected StandardSearchPanel searchPanel() {
		return new ExpenseArticleSearchPanel();
	}

	public SearchQuery searchQuery() {
		return QueryFactory.instance().expensesArticlesSearchQuery();
	}

	public MessageId titleMessageId() {
		return MessageId.expensesArticles;
	}

}
