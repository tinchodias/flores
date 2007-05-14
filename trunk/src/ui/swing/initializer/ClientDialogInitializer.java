package ui.swing.initializer;

import model.JuridicPerson;
import ui.action.CreateClientAction;
import ui.action.CloseDialogAction;
import ui.action.ModifyClientAction;
import ui.component.DialogUI;
import ui.swing.component.ClientDialog;

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
