package ui.controller.initializer.search;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.controller.action.ShowCurrentCashAction;
import ui.view.swing.component.CashBookEntrySearchPanel;
import ui.view.swing.component.StandardSearchDialog;
import ui.view.swing.component.StandardSearchPanel;

public class CashBookDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		searchDialog.getSearchPanel().add(new ShowCurrentCashAction());
	}

	protected StandardSearchPanel searchPanel() {
		return new CashBookEntrySearchPanel();
	}

	protected SearchQuery searchQuery() {
		return QueryFactory.instance().cashBookEntrySearchQuery();
	}

	protected MessageId titleMessageId() {
		return MessageId.cashBook;
	}

}
