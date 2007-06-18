package ui.controller.initializer;

import ui.controller.action.CloseDialogAction;
import ui.controller.action.CreateStockDropOutAction;
import ui.view.component.DialogUI;
import ui.view.swing.component.StockDropOutDialog;

public class CreateStockDropOutDialogInitializer implements DialogInitializer {

	public DialogUI dialog() {
		StockDropOutDialog dialog = new StockDropOutDialog();
		
		dialog.setArticleSearchInitializer(new StockDialogInitializer());
		
		dialog.setAcceptAction(new CreateStockDropOutAction(dialog));
		dialog.setCancelAction(new CloseDialogAction(dialog));
		
		return dialog;
	}

}
