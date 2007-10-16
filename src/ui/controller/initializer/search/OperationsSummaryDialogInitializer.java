package ui.controller.initializer.search;

import message.MessageId;
import query.framework.query.OperationSummarySearchQuery;
import query.framework.query.SearchQuery;
import ui.controller.action.Action;
import ui.controller.action.ExecuteOnSelectionAction;
import ui.controller.action.ShowOperationSearchDialogAction;
import ui.view.swing.component.search.IntervalSearchPanel;
import ui.view.swing.component.search.StandardSearchDialog;
import ui.view.swing.component.search.StandardSearchPanel;

public class OperationsSummaryDialogInitializer extends StandardSearchDialogInitializer {

	protected void addActions(StandardSearchDialog searchDialog) {
		StandardSearchPanel searchPanel = searchDialog.getSearchPanel();
		Action onSelectionAction = new ShowOperationSearchDialogAction(searchPanel);
		Action executeOnSelectionAction = new ExecuteOnSelectionAction(searchPanel, onSelectionAction);
		searchPanel.add(executeOnSelectionAction);
		searchPanel.setDefaultAction(executeOnSelectionAction);
	}

	protected StandardSearchPanel searchPanel() {
		return new IntervalSearchPanel();
	}

	public SearchQuery searchQuery() {
		return new OperationSummarySearchQuery();
	}

	public MessageId titleMessageId() {
		return MessageId.operationsSummary;
	}

}
