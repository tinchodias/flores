package ui.action;

import ui.swing.initializer.LoginDialogInitializer;

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
