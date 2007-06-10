package ui.controller.initializer;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.controller.action.ShowDialogAction;
import ui.controller.action.ShowModifyClientAction;
import ui.view.swing.component.ClientSearchPanel;
import ui.view.swing.component.StandardSearchDialog;
import ui.view.swing.component.StandardSearchPanel;

public class ClientsDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		searchDialog.add(new ShowDialogAction(new CreateClientDialogInitializer(), MessageId.create));
		searchDialog.add(new ShowModifyClientAction(searchDialog.getSearchPanel()));
	}

	protected StandardSearchPanel searchPanel() {
		return new ClientSearchPanel();
	}

	protected SearchQuery searchQuery() {
		return QueryFactory.instance().clientSearchQuery();
	}

	protected MessageId titleMessageId() {
		return MessageId.clientsDialogTitle;
	}

}
