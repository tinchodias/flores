package ui.controller.initializer;

import ui.controller.action.CloseDialogAction;
import ui.controller.action.ModifyPricePercentagesAction;
import ui.view.component.DialogUI;
import ui.view.component.SearchUI;
import ui.view.swing.component.ModifyPercentageDialog;

public class ModifyPricePercentagesDialogInitializer implements DialogInitializer {

	private final SearchUI searchUI;

	public ModifyPricePercentagesDialogInitializer(SearchUI searchUI) {
		this.searchUI = searchUI;
	}

	public DialogUI dialog() {
		ModifyPercentageDialog dialog = new ModifyPercentageDialog();
		
		dialog.setAcceptAction(new ModifyPricePercentagesAction(dialog, searchUI));
		dialog.setCancelAction(new CloseDialogAction(dialog));
		
		return dialog;
	}

}
