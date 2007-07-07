package ui.controller.initializer.search;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.controller.initializer.detail.CreateSellDialogInitializer;
import ui.view.swing.component.SellSearchPanel;
import ui.view.swing.component.StandardSearchDialog;
import ui.view.swing.component.StandardSearchPanel;

public class SellsDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		searchDialog.getSearchPanel().add(showAndRefreshAction(new CreateSellDialogInitializer(), MessageId.create, searchDialog));
	}

	protected StandardSearchPanel searchPanel() {
		return new SellSearchPanel();
	}

	protected SearchQuery searchQuery() {
		return QueryFactory.instance().sellSearchQuery();
	}

	protected MessageId titleMessageId() {
		return MessageId.sells;
	}

}
