package ui.controller.initializer.search;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.controller.initializer.detail.BuyDetailInitializer;
import ui.controller.initializer.detail.mode.DetailMode;
import ui.controller.populator.BuyPopulator;
import ui.view.swing.component.BuySearchPanel;
import ui.view.swing.component.StandardSearchDialog;
import ui.view.swing.component.StandardSearchPanel;

public class BuysDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		addShowAndRefreshAction(new BuyDetailInitializer(DetailMode.CREATING, new BuyPopulator()), MessageId.create, searchDialog);
		addShowOnSelectionAndRefreshAction(new BuyDetailInitializer(DetailMode.VIEWING, new BuyPopulator()), MessageId.view, searchDialog);
	}

	protected StandardSearchPanel searchPanel() {
		return new BuySearchPanel();
	}

	protected SearchQuery searchQuery() {
		return QueryFactory.instance().buySearchQuery();
	}

	protected MessageId titleMessageId() {
		return MessageId.buys;
	}

}
