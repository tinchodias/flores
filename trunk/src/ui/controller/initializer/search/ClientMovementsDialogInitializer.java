package ui.controller.initializer.search;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.view.swing.component.search.ClientMovementSearchPanel;
import ui.view.swing.component.search.StandardSearchDialog;
import ui.view.swing.component.search.StandardSearchPanel;
import util.ValueHolder;

public class ClientMovementsDialogInitializer extends StandardSearchDialogInitializer {

	private final ValueHolder clientHolder;

	public ClientMovementsDialogInitializer(ValueHolder valueHolder) {
		this.clientHolder = valueHolder;
	}

	protected void addActions(StandardSearchDialog searchDialog) {
//		addShowOnSelectionAction(new ClientMovementsDialogInitializer(), MessageId.clientMovements, searchDialog);
	}

	protected StandardSearchPanel searchPanel() {
		return new ClientMovementSearchPanel(clientHolder);
	}

	protected SearchQuery searchQuery() {
		return QueryFactory.instance().clientMovementsQuery();
	}

	protected MessageId titleMessageId() {
		return MessageId.clientMovements;
	}

}
