package ui.controller.initializer.search;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.controller.initializer.detail.ExpenseArticleDetailInitializer;
import ui.controller.populator.ExpenseArticlePopulator;
import ui.view.swing.component.ExpenseArticleSearchPanel;
import ui.view.swing.component.StandardSearchDialog;
import ui.view.swing.component.StandardSearchPanel;

public class ExpensesArticlesDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		addShowCreatingAction(new ExpenseArticleDetailInitializer(), new ExpenseArticlePopulator(), searchDialog);
		addShowModifyingAction(new ExpenseArticleDetailInitializer(), new ExpenseArticlePopulator(), searchDialog);
	}

	protected StandardSearchPanel searchPanel() {
		return new ExpenseArticleSearchPanel();
	}

	protected SearchQuery searchQuery() {
		return QueryFactory.instance().expensesArticlesSearchQuery();
	}

	protected MessageId titleMessageId() {
		return MessageId.expensesArticles;
	}

}
