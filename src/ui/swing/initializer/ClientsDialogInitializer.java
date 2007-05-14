package ui.swing.initializer;

import ui.action.ClientSearchAction;
import ui.action.CloseDialogAction;
import ui.action.ShowClientAction;
import ui.action.ShowDialogAction;
import ui.component.ClientsUI;
import ui.swing.component.ClientsDialog;

public class ClientsDialogInitializer {

	public ClientsUI dialog() {
		ClientsDialog clientsDialog = new ClientsDialog();
		
		clientsDialog.getSearchPanel().setSearchAction(
				new ClientSearchAction(clientsDialog.getSearchPanel()));
		
		clientsDialog.setOkButtonAction(new CloseDialogAction(clientsDialog));
		clientsDialog.setAddClientButtonAction(new ShowDialogAction(new ClientDialogInitializer()));
		clientsDialog.setModifyClientButtonAction(new ShowClientAction(clientsDialog.getSearchPanel()));
		
		return clientsDialog;
	}

}
