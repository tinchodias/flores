package ui.controller.initializer;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.view.swing.component.StandardSearchDialog;
import ui.view.swing.component.StandardSearchPanel;
import ui.view.swing.component.SuppliersSearchPanel;

public class SuppliersDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		searchDialog.getSearchPanel().add(showAndRefreshAction(new CreateSupplierDialogInitializer(), MessageId.create, searchDialog));
	}

	protected StandardSearchPanel searchPanel() {
		return new SuppliersSearchPanel();
	}

	protected SearchQuery searchQuery() {
		return QueryFactory.instance().suppliersSearchQuery();
	}

	protected MessageId titleMessageId() {
		return MessageId.suppliersDialogTitle;
	}

}
