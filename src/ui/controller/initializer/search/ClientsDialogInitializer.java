package ui.controller.initializer.search;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.controller.initializer.detail.ClientDetailInitializer;
import ui.view.swing.component.search.ClientSearchPanel;
import ui.view.swing.component.search.StandardSearchDialog;
import ui.view.swing.component.search.StandardSearchPanel;

public class ClientsDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		addShowCreatingAction(new ClientDetailInitializer(), searchDialog);
		addShowModifyingAction(new ClientDetailInitializer(), searchDialog);
	}

	protected StandardSearchPanel searchPanel() {
		return new ClientSearchPanel();
	}

	protected SearchQuery searchQuery() {
		return QueryFactory.instance().clientSearchQuery();
	}

	protected MessageId titleMessageId() {
		return MessageId.clients;
	}

}
