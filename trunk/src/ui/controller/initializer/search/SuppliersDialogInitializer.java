package ui.controller.initializer.search;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.controller.initializer.detail.SupplierDetailInitializer;
import ui.controller.populator.SupplierPopulator;
import ui.view.swing.component.search.StandardSearchDialog;
import ui.view.swing.component.search.StandardSearchPanel;
import ui.view.swing.component.search.SuppliersSearchPanel;

public class SuppliersDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		addShowCreatingAction(new SupplierDetailInitializer(), new SupplierPopulator(), searchDialog);
		addShowModifyingAction(new SupplierDetailInitializer(), new SupplierPopulator(), searchDialog);
	}

	protected StandardSearchPanel searchPanel() {
		return new SuppliersSearchPanel();
	}

	protected SearchQuery searchQuery() {
		return QueryFactory.instance().suppliersSearchQuery();
	}

	protected MessageId titleMessageId() {
		return MessageId.suppliers;
	}

}
