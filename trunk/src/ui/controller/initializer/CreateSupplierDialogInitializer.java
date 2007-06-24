package ui.controller.initializer;

import ui.controller.action.CloseDialogAction;
import ui.controller.action.CreateSupplierAction;
import ui.view.component.DialogUI;
import ui.view.swing.component.SupplierDialog;

public class CreateSupplierDialogInitializer implements DialogInitializer {
	
	public DialogUI dialog() {
		SupplierDialog dialog = new SupplierDialog();

		//TODO Setear modo de pantalla
		
		dialog.setAcceptAction(new CreateSupplierAction(dialog));
		dialog.setCancelAction(new CloseDialogAction(dialog));
		
		dialog.getAddressUI().setCitySearchInitializer(new CitiesDialogInitializer());
		
		return dialog;
	}

}