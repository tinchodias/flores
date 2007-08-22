package ui.controller.initializer.search;

import message.MessageId;
import query.framework.query.SearchQuery;
import ui.controller.action.Action;
import ui.controller.action.CloseDialogAction;
import ui.controller.action.CompositeAction;
import ui.controller.action.SearchAction;
import ui.controller.action.ExecuteOnSelectionAction;
import ui.controller.action.ShowDialogAction;
import ui.controller.initializer.DialogInitializer;
import ui.controller.initializer.detail.DetailDialogInitializer;
import ui.controller.initializer.detail.mode.DetailMode;
import ui.controller.populator.DetailPopulator;
import ui.view.component.SearchDialogUI;
import ui.view.swing.component.search.StandardSearchDialog;
import ui.view.swing.component.search.StandardSearchPanel;
import util.ValueHolder;

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
		Action showAction = new ShowDialogAction(initializer);
		Action refreshAction = searchDialog.getSearchPanel().getSearchAction();
		return new CompositeAction(showAction, refreshAction, messageId);
	}
	
	protected static void addShowAndRefreshAction(DialogInitializer initializer, MessageId messageId, StandardSearchDialog searchDialog) {
		Action showAndRefreshAction = showAndRefreshAction(initializer, messageId, searchDialog);
		searchDialog.getSearchPanel().add(showAndRefreshAction);
	}

	protected static void addShowOnSelectionAction(DetailDialogInitializer initializer, MessageId messageId, StandardSearchDialog searchDialog) {
		Action showAction = new ShowDialogAction(initializer);
		addOnSelectionAction(initializer.populator(), messageId, searchDialog, showAction);
	}

	protected static void addShowOnSelectionAndRefreshAction(DetailDialogInitializer initializer, MessageId messageId, StandardSearchDialog searchDialog) {
		Action showAndRefreshAction = showAndRefreshAction(initializer, messageId, searchDialog);
		addOnSelectionAction(initializer.populator(), messageId, searchDialog, showAndRefreshAction);
	}

	protected static void addOnSelectionAction(ValueHolder valueHolder, MessageId messageId, StandardSearchDialog searchDialog, Action onSelectionAction) {
		Action executeOnSelectionAction = 
			new ExecuteOnSelectionAction(searchDialog.getSearchPanel(), valueHolder, onSelectionAction, messageId);
		searchDialog.getSearchPanel().add(executeOnSelectionAction);
	}

	protected static void addShowCreatingAction(DetailDialogInitializer initializer, DetailPopulator populator, StandardSearchDialog searchDialog) {
		initializer.mode(DetailMode.CREATING);
		initializer.populator(populator);
		addShowAndRefreshAction(initializer, MessageId.create, searchDialog);
	}

	protected static void addShowModifyingAction(DetailDialogInitializer initializer, DetailPopulator populator, StandardSearchDialog searchDialog) {
		initializer.mode(DetailMode.MODIFYING);
		initializer.populator(populator);
		addShowOnSelectionAndRefreshAction(initializer, MessageId.modify, searchDialog);
	}

	protected static void addShowViewingAction(DetailDialogInitializer initializer, DetailPopulator populator, StandardSearchDialog searchDialog) {
		initializer.mode(DetailMode.VIEWING);
		initializer.populator(populator);
		addShowOnSelectionAction(initializer, MessageId.view, searchDialog);
	}

	
}
