package ui.action;

import ui.swing.initializer.ClientsDialogInitializer;

public class ShowClientsAction implements Action {

	public void execute() {
		new ClientsDialogInitializer().dialog().setVisible(true);
	}

	public String getTitle() {
		return "Ver clientes";
	}

}
