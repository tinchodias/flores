package ui.controller.initializer;

import ui.controller.action.CloseDialogAction;
import ui.controller.action.CreateClientAction;
import ui.view.component.DialogUI;
import ui.view.swing.component.ClientDialog;

public class CreateClientDialogInitializer implements DialogInitializer {
	
	public DialogUI dialog() {
		ClientDialog clientDialog = new ClientDialog();

		//TODO Setear modo de pantalla
		
		clientDialog.setAcceptAction(new CreateClientAction(clientDialog));
		clientDialog.setCancelAction(new CloseDialogAction(clientDialog));
		
		return clientDialog;
	}

}
