package ui.controller.initializer.search;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.controller.initializer.detail.SellDetailInitializer;
import ui.controller.initializer.detail.mode.DetailMode;
import ui.controller.populator.SellPopulator;
import ui.view.swing.component.SellSearchPanel;
import ui.view.swing.component.StandardSearchDialog;
import ui.view.swing.component.StandardSearchPanel;

public class SellsDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		addShowAndRefreshAction(new SellDetailInitializer(DetailMode.CREATING, new SellPopulator()), MessageId.create, searchDialog);
		addShowOnSelectionAndRefreshAction(new SellDetailInitializer(DetailMode.VIEWING, new SellPopulator()), MessageId.view, searchDialog);
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
