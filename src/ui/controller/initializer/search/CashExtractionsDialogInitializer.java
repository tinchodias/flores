package ui.controller.initializer.search;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.controller.initializer.detail.CashExtractionDetailInitializer;
import ui.view.swing.component.search.IntervalSearchPanel;
import ui.view.swing.component.search.StandardSearchDialog;
import ui.view.swing.component.search.StandardSearchPanel;

public class CashExtractionsDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		addShowCreatingAction(new CashExtractionDetailInitializer(), searchDialog);
	}

	protected StandardSearchPanel searchPanel() {
		return new IntervalSearchPanel();
	}

	protected SearchQuery searchQuery() {
		return QueryFactory.instance().cashExtractionsSearchQuery();
	}

	protected MessageId titleMessageId() {
		return MessageId.cashExtractions;
	}

}
