package ui.controller.initializer;

import ui.controller.action.LoginAction;
import ui.view.component.LoginUI;
import ui.view.swing.component.LoginDialog;

public class LoginDialogInitializer implements DialogInitializer {

	public LoginUI dialog() {
		LoginDialog dialog = new LoginDialog();
		dialog.setLoginButtonAction(new LoginAction(dialog));
		return dialog;
	}
	
}
