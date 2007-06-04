package ui.controller.initializer;

import message.MessageId;
import ui.controller.action.ClientSearchAction;
import ui.controller.action.CloseDialogAction;
import ui.controller.action.ShowDialogAction;
import ui.controller.action.ShowModifyClientAction;
import ui.view.component.ClientsUI;
import ui.view.swing.component.ClientsDialog;

public class ClientsDialogInitializer implements DialogInitializer {

	public ClientsUI dialog() {
		ClientsDialog clientsDialog = new ClientsDialog();
		
		ClientSearchAction clientSearchAction = new ClientSearchAction(clientsDialog.getSearchPanel());
		clientsDialog.getSearchPanel().setSearchAction(clientSearchAction);
		clientSearchAction.execute();
		
		clientsDialog.setOkButtonAction(new CloseDialogAction(clientsDialog));
		clientsDialog.setAddClientButtonAction(new ShowDialogAction(new CreateClientDialogInitializer(), MessageId.create));
		clientsDialog.setModifyClientButtonAction(new ShowModifyClientAction(clientsDialog.getSearchPanel()));
		
		return clientsDialog;
	}

}
