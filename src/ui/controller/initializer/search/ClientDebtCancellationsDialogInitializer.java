package ui.controller.initializer.search;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.controller.initializer.detail.ClientDebtCancellationDetailInitializer;
import ui.view.swing.component.search.IntervalSearchPanel;
import ui.view.swing.component.search.StandardSearchDialog;
import ui.view.swing.component.search.StandardSearchPanel;

public class ClientDebtCancellationsDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		addShowCreatingAction(new ClientDebtCancellationDetailInitializer(), searchDialog);
	}

	protected StandardSearchPanel searchPanel() {
		return new IntervalSearchPanel();
	}

	protected SearchQuery searchQuery() {
		return QueryFactory.instance().clientDebtCancellationsSearchQuery();
	}

	public MessageId titleMessageId() {
		return MessageId.clientDebtCancellations;
	}

}
