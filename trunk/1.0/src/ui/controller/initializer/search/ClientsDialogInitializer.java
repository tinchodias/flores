package ui.controller.initializer.search;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.controller.initializer.DialogInitializer;
import ui.controller.initializer.detail.ClientDetailInitializer;
import ui.view.swing.component.search.ClientSearchPanel;
import ui.view.swing.component.search.StandardSearchDialog;
import ui.view.swing.component.search.StandardSearchPanel;

public class ClientsDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		addShowCreatingAction(new ClientDetailInitializer(), searchDialog);
		addShowModifyingAction(new ClientDetailInitializer(), searchDialog);
		
		DialogInitializer movementsDialogInitializer = new ClientMovementsDialogInitializer(
				new SingleSelectionValueHolder(searchDialog.getSearchPanel()));
		addShowOnSelectionAction(movementsDialogInitializer, MessageId.clientMovements, searchDialog);
	}

	protected StandardSearchPanel searchPanel() {
		return new ClientSearchPanel();
	}

	public SearchQuery searchQuery() {
		return QueryFactory.instance().clientSearchQuery();
	}

	public MessageId titleMessageId() {
		return MessageId.clients;
	}

}
