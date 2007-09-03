package ui.controller.initializer.search;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.controller.action.PrintSellReportAction;
import ui.controller.initializer.detail.SellDetailInitializer;
import ui.view.swing.component.search.SellSearchPanel;
import ui.view.swing.component.search.StandardSearchDialog;
import ui.view.swing.component.search.StandardSearchPanel;

public class SellsDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		addShowCreatingAction(new SellDetailInitializer(), searchDialog);
		addShowViewingAction(new SellDetailInitializer(), searchDialog);
		
		PrintSellReportAction printAction = new PrintSellReportAction(new SingleSelectionValueHolder(searchDialog.getSearchPanel()));
		addOnSelectionAction(MessageId.print, searchDialog, printAction);
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
