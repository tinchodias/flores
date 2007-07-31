package ui.controller.initializer.search;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.controller.initializer.ModifyPricePercentagesDialogInitializer;
import ui.view.swing.component.PricePercentageSearchPanel;
import ui.view.swing.component.StandardSearchDialog;
import ui.view.swing.component.StandardSearchPanel;

public class PricePercentagesDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		addShowAndRefreshAction(new ModifyPricePercentagesDialogInitializer(searchDialog.getSearchPanel()), MessageId.modifyPercentage, searchDialog);
	}

	protected StandardSearchPanel searchPanel() {
		return new PricePercentageSearchPanel();
	}

	protected SearchQuery searchQuery() {
		return QueryFactory.instance().pricePercentageSearchQuery();
	}

	protected MessageId titleMessageId() {
		return MessageId.pricesDialogTitle;
	}

}
