package ui.controller.initializer;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.view.swing.component.ClientSearchPanel;
import ui.view.swing.component.StandardSearchDialog;
import ui.view.swing.component.StandardSearchPanel;

public class ClientsDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		searchDialog.getSearchPanel().add(showAndRefreshAction(new CreateClientDialogInitializer(), MessageId.create, searchDialog));

		//TODO
//		searchDialog.getSearchPanel().add(new ShowModifyClientAction(searchDialog.getSearchPanel()));
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
