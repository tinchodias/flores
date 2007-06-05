package ui.controller.initializer;

import message.MessageId;
import query.QueryFactory;
import ui.controller.action.Action;
import ui.controller.action.CloseDialogAction;
import ui.controller.action.SearchAction;
import ui.controller.action.ShowDialogAction;
import ui.controller.action.ShowModifyClientAction;
import ui.view.component.ClientsUI;
import ui.view.swing.component.ClientsDialog;

public class ClientsDialogInitializer implements DialogInitializer {

	public ClientsUI dialog() {
		ClientsDialog clientsDialog = new ClientsDialog();
		
		Action clientSearchAction = new SearchAction(clientsDialog.getSearchPanel(), QueryFactory.instance().clientSearchQuery());
		clientsDialog.getSearchPanel().setSearchAction(clientSearchAction);
		clientSearchAction.execute();
		
		clientsDialog.setOkButtonAction(new CloseDialogAction(clientsDialog));
		clientsDialog.setAddClientButtonAction(new ShowDialogAction(new CreateClientDialogInitializer(), MessageId.create));
		clientsDialog.setModifyClientButtonAction(new ShowModifyClientAction(clientsDialog.getSearchPanel()));
		
		return clientsDialog;
	}

}
