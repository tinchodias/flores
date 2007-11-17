package ui.controller.initializer;

import ui.controller.action.CalculateCommissionsAction;
import ui.view.component.DialogUI;
import ui.view.swing.component.CommissionCalculationDialog;

public class CommissionCalculationDialogInitializer implements DialogInitializer {

	public DialogUI dialog() {
		CommissionCalculationDialog dialog = new CommissionCalculationDialog();
		dialog.setAcceptAction(new CalculateCommissionsAction(dialog));
		return dialog;
	}

}
