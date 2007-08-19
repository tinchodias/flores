package ui.controller.initializer.search;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.controller.initializer.detail.ExpenseDetailInitializer;
import ui.controller.populator.ExpensePopulator;
import ui.view.swing.component.search.ExpenseSearchPanel;
import ui.view.swing.component.search.StandardSearchDialog;
import ui.view.swing.component.search.StandardSearchPanel;

public class ExpensesDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		addShowCreatingAction(new ExpenseDetailInitializer(), new ExpensePopulator(), searchDialog);
	}

	protected StandardSearchPanel searchPanel() {
		return new ExpenseSearchPanel();
	}

	protected SearchQuery searchQuery() {
		return QueryFactory.instance().expensesSearchQuery();
	}

	protected MessageId titleMessageId() {
		return MessageId.expenses;
	}

}
