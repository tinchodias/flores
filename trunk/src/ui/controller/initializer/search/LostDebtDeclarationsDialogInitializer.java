package ui.controller.initializer.search;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.controller.initializer.detail.LostDebtDeclarationDetailInitializer;
import ui.view.swing.component.search.IntervalSearchPanel;
import ui.view.swing.component.search.StandardSearchDialog;
import ui.view.swing.component.search.StandardSearchPanel;

public class LostDebtDeclarationsDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		addShowCreatingAction(new LostDebtDeclarationDetailInitializer(), searchDialog);
	}

	protected StandardSearchPanel searchPanel() {
		return new IntervalSearchPanel();
	}

	public SearchQuery searchQuery() {
		return QueryFactory.instance().lostDebtDeclarationsSearchQuery();
	}

	public MessageId titleMessageId() {
		return MessageId.lostDebtDeclarations;
	}

}
