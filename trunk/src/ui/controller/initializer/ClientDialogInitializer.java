package ui.controller.initializer;

import model.JuridicPerson;
import ui.controller.action.CloseDialogAction;
import ui.controller.action.CreateClientAction;
import ui.controller.action.ModifyClientAction;
import ui.view.component.DialogUI;
import ui.view.swing.component.ClientDialog;

public class ClientDialogInitializer implements DialogInitializer {

	public DialogUI dialog() {
		ClientDialog clientDialog = new ClientDialog();
		
		clientDialog.setCreateAction(new CreateClientAction(clientDialog));
		clientDialog.setCancelAction(new CloseDialogAction(clientDialog));
		
		return clientDialog;
	}

	public DialogUI dialog(JuridicPerson client) {
		ClientDialog clientDialog = new ClientDialog();
		
		clientDialog.setClientName(client.getName());
		
		clientDialog.setModifyAction(new ModifyClientAction(clientDialog, client));
		clientDialog.setCancelAction(new CloseDialogAction(clientDialog));
		
		return clientDialog;
	}

}
