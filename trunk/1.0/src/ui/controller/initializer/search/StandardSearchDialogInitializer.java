package ui.controller.initializer.search;

import message.MessageId;
import query.framework.query.SearchQuery;
import ui.controller.action.Action;
import ui.controller.action.CloseDialogAction;
import ui.controller.action.CompositeAction;
import ui.controller.action.ExecuteOnSelectionAction;
import ui.controller.action.SearchAction;
import ui.controller.action.ShowDialogAction;
import ui.controller.initializer.DialogInitializer;
import ui.controller.initializer.detail.DetailDialogInitializer;
import ui.controller.initializer.detail.mode.DetailMode;
import ui.view.component.SearchDialogUI;
import ui.view.swing.component.search.StandardSearchDialog;
import ui.view.swing.component.search.StandardSearchPanel;

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

	public abstract SearchQuery searchQuery();

	public abstract MessageId titleMessageId();

	protected abstract void addActions(StandardSearchDialog searchDialog);

	protected abstract StandardSearchPanel searchPanel();

	protected static Action showAndRefreshAction(DialogInitializer initializer, MessageId messageId, StandardSearchDialog searchDialog) {
		Action showAction = new ShowDialogAction(initializer);
		Action refreshAction = searchDialog.getSearchPanel().getSearchAction();
		return new CompositeAction(showAction, refreshAction, messageId);
	}
	
	protected static void addShowAndRefreshAction(DialogInitializer initializer, MessageId messageId, StandardSearchDialog searchDialog) {
		Action showAndRefreshAction = showAndRefreshAction(initializer, messageId, searchDialog);
		searchDialog.getSearchPanel().add(showAndRefreshAction);
	}

	protected static void addShowOnSelectionAction(DialogInitializer initializer, MessageId messageId, StandardSearchDialog searchDialog) {
		Action showAction = new ShowDialogAction(initializer, messageId);
		addOnSelectionAction(searchDialog, showAction);
	}

	protected static void addShowOnSelectionAndRefreshAction(DetailDialogInitializer initializer, MessageId messageId, StandardSearchDialog searchDialog) {
		Action showAndRefreshAction = showAndRefreshAction(initializer, messageId, searchDialog);
		addOnSelectionAction(searchDialog, showAndRefreshAction);
	}

	protected static void addOnSelectionAction(StandardSearchDialog searchDialog, Action onSelectionAction) {
		searchDialog.getSearchPanel().add(new ExecuteOnSelectionAction(searchDialog.getSearchPanel(), onSelectionAction));
	}

	protected static void addShowCreatingAction(DetailDialogInitializer initializer, StandardSearchDialog searchDialog) {
		initializer.mode(DetailMode.CREATING);
		initializer.objectHolder(new SingleSelectionValueHolder(searchDialog.getSearchPanel()));
		addShowAndRefreshAction(initializer, MessageId.create, searchDialog);
	}

	protected static void addShowModifyingAction(DetailDialogInitializer initializer, StandardSearchDialog searchDialog) {
		initializer.mode(DetailMode.MODIFYING);
		initializer.objectHolder(new SingleSelectionValueHolder(searchDialog.getSearchPanel()));
		addShowOnSelectionAndRefreshAction(initializer, MessageId.modify, searchDialog);
	}

	protected static void addShowViewingAction(DetailDialogInitializer initializer, StandardSearchDialog searchDialog) {
		initializer.mode(DetailMode.VIEWING);
		initializer.objectHolder(new SingleSelectionValueHolder(searchDialog.getSearchPanel()));
		addShowOnSelectionAction(initializer, MessageId.view, searchDialog);
	}
	
}
