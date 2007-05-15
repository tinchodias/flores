package ui.controller.action;

import ui.controller.initializer.ClientsDialogInitializer;

public class ShowClientsAction implements Action {

	public void execute() {
		new ClientsDialogInitializer().dialog().setVisible(true);
	}

	public String getTitle() {
		return "Ver clientes";
	}

}
