package ui.controller.initializer;

import ui.view.component.DialogUI;
import ui.view.swing.component.StockDropOutDialog;

public class CreateStockDropOutDialogInitializer implements DialogInitializer {

	public DialogUI dialog() {
		StockDropOutDialog dialog = new StockDropOutDialog();
		
		return dialog;
	}

}
