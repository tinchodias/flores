package ui.controller.initializer.search;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.controller.initializer.detail.ClientDetailInitializer;
import ui.controller.populator.ClientPopulator;
import ui.view.swing.component.ClientSearchPanel;
import ui.view.swing.component.StandardSearchDialog;
import ui.view.swing.component.StandardSearchPanel;

public class ClientsDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		addShowCreatingAction(new ClientDetailInitializer(), new ClientPopulator(), searchDialog);
		addShowModifyingAction(new ClientDetailInitializer(), new ClientPopulator(), searchDialog);
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
