package ui.controller.initializer;

import message.MessageId;
import query.QueryFactory;
import ui.controller.action.Action;
import ui.controller.action.CloseDialogAction;
import ui.controller.action.SearchAction;
import ui.controller.action.ShowDialogAction;
import ui.view.component.DialogUI;
import ui.view.swing.component.StockDropOutsDialog;

public class StockDropOutsDialogInitializer implements DialogInitializer {

	public DialogUI dialog() {
		StockDropOutsDialog dialog = new StockDropOutsDialog();
		
		Action searchAction = new SearchAction(dialog.getSearchPanel(), QueryFactory.instance().stockDropOutSearchQuery());
		dialog.getSearchPanel().setSearchAction(searchAction);
		searchAction.execute();
		
		Action showCreateStockDropOutDialogAction = new ShowDialogAction(new CreateStockDropOutDialogInitializer(), MessageId.create);

		dialog.setOkAction(new CloseDialogAction(dialog));
		dialog.setCreateAction(showCreateStockDropOutDialogAction);
		
		return dialog;
	}

}
