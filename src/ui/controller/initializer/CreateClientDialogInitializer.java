package ui.controller.initializer;

import ui.controller.action.CloseDialogAction;
import ui.controller.action.CreateClientAction;
import ui.view.component.DialogUI;
import ui.view.swing.component.ClientDialog;

public class CreateClientDialogInitializer implements DialogInitializer {
	
	public DialogUI dialog() {
		ClientDialog dialog = new ClientDialog();

		//TODO Setear modo de pantalla
		
		dialog.setAcceptAction(new CreateClientAction(dialog));
		dialog.setCancelAction(new CloseDialogAction(dialog));
		
		dialog.getAddressUI().setCitySearchInitializer(new CitiesDialogInitializer());
		
		return dialog;
	}

}
