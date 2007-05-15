package ui.controller.action;

import ui.controller.initializer.LoginDialogInitializer;

public class ShowLoginDialogAction implements Action {

	public ShowLoginDialogAction() {
	}

	public void execute() {
		new LoginDialogInitializer().dialog().setVisible(true);
	}

	public String getTitle() {
		return "Iniciar sesión";
	}
	
}
