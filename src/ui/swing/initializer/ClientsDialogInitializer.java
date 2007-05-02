package ui.swing.initializer;

import ui.action.ClientSearchAction;
import ui.component.ClientsUI;
import ui.swing.component.ClientsDialog;

public class ClientsDialogInitializer {

	public ClientsUI dialog() {
		ClientsDialog clientsDialog = new ClientsDialog();
		
		clientsDialog.getSearchPanel().setSearchAction(
				new ClientSearchAction(clientsDialog.getSearchPanel()));
		
		return clientsDialog;
	}

}
