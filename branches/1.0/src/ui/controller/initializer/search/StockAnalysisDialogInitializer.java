package ui.controller.initializer.search;

import message.MessageId;
import query.QueryFactory;
import query.framework.query.SearchQuery;
import ui.view.swing.component.search.IntervalSearchPanel;
import ui.view.swing.component.search.StandardSearchDialog;
import ui.view.swing.component.search.StandardSearchPanel;

public class StockAnalysisDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
	}

	protected StandardSearchPanel searchPanel() {
		return new IntervalSearchPanel();
	}

	public SearchQuery searchQuery() {
		return QueryFactory.instance().stockAnalysisSearchQuery();
	}

	public MessageId titleMessageId() {
		return MessageId.stockAnalysis;
	}

}
