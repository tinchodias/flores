package ui.controller.initializer;

import model.JuridicPerson;
import ui.controller.action.CloseDialogAction;
import ui.controller.action.ModifyClientAction;
import ui.view.component.DialogUI;
import ui.view.swing.component.ClientDialog;

public class ModifyClientDialogInitializer implements DialogInitializer {

	private final JuridicPerson client;

	public ModifyClientDialogInitializer(JuridicPerson client) {
		this.client = client;
	}

	public DialogUI dialog() {
		ClientDialog clientDialog = new ClientDialog();

		//TODO Setear modos de pantalla
		
		clientDialog.setClientName(client.getName());
		
		clientDialog.setAcceptAction(new ModifyClientAction(clientDialog, client));
		clientDialog.setCancelAction(new CloseDialogAction(clientDialog));
		
		return clientDialog;
	}

}
