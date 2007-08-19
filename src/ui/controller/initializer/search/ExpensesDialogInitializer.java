package ui.controller.initializer.search;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.controller.initializer.detail.ExpenseDetailInitializer;
import ui.controller.populator.ExpensePopulator;
import ui.view.swing.component.ExpenseSearchPanel;
import ui.view.swing.component.StandardSearchDialog;
import ui.view.swing.component.StandardSearchPanel;

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
