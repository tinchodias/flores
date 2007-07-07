package ui.controller.initializer.search;

import message.MessageId;
import query.framework.query.SearchQuery;
import ui.controller.action.Action;
import ui.controller.action.CloseDialogAction;
import ui.controller.action.CompositeAction;
import ui.controller.action.SearchAction;
import ui.controller.action.ShowDialogAction;
import ui.controller.initializer.DialogInitializer;
import ui.view.component.SearchDialogUI;
import ui.view.swing.component.StandardSearchDialog;
import ui.view.swing.component.StandardSearchPanel;

public abstract class StandardSearchDialogInitializer implements SearchDialogInitializer {

	public SearchDialogUI dialog() {
		StandardSearchPanel searchPanel = searchPanel();
		StandardSearchDialog searchDialog = new StandardSearchDialog(titleMessageId(), searchPanel);
		
		Action searchAction = new SearchAction(searchPanel, searchQuery());
		searchPanel.setSearchAction(searchAction);
		searchAction.execute();
		
		searchDialog.setCloseAction(new CloseDialogAction(searchDialog));
		addActions(searchDialog);
		
		return searchDialog;
	}

	protected abstract SearchQuery searchQuery();

	protected abstract MessageId titleMessageId();

	protected abstract void addActions(StandardSearchDialog searchDialog);

	protected abstract StandardSearchPanel searchPanel();

	protected static Action showAndRefreshAction(DialogInitializer initializer, MessageId messageId, StandardSearchDialog searchDialog) {
		Action searchAction = searchDialog.getSearchPanel().getSearchAction();
		Action showAction = new ShowDialogAction(initializer);
		return new CompositeAction(showAction, searchAction, messageId);
	}

}