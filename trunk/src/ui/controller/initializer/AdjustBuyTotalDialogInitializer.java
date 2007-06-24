package ui.controller.initializer;

import ui.controller.action.AdjustBuyTotalAction;
import ui.controller.action.CloseDialogAction;
import ui.view.component.DialogUI;
import ui.view.swing.component.AdjustBuyTotalDialog;
import ui.view.swing.component.BuyDialog;

public class AdjustBuyTotalDialogInitializer implements DialogInitializer {

	private final BuyDialog buyDialog;

	public AdjustBuyTotalDialogInitializer(BuyDialog buyDialog) {
		this.buyDialog = buyDialog;
	}

	public DialogUI dialog() {
		AdjustBuyTotalDialog dialog = new AdjustBuyTotalDialog();
		
		dialog.setAcceptAction(new AdjustBuyTotalAction(dialog, buyDialog));
		dialog.setCancelAction(new CloseDialogAction(dialog));
		return dialog;
	}

}
