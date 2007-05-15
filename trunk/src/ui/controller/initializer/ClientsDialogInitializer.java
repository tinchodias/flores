package ui.controller.initializer;

import ui.controller.action.ClientSearchAction;
import ui.controller.action.CloseDialogAction;
import ui.controller.action.ShowClientAction;
import ui.controller.action.ShowDialogAction;
import ui.view.component.ClientsUI;
import ui.view.swing.component.ClientsDialog;

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
