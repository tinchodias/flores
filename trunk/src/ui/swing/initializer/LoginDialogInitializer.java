package ui.swing.initializer;

import ui.action.LoginAction;
import ui.component.LoginUI;
import ui.swing.component.LoginDialog;

public class LoginDialogInitializer {

	public LoginUI dialog() {
		LoginDialog dialog = new LoginDialog();
		dialog.setLoginButtonAction(new LoginAction(dialog));
		return dialog;
	}
	
}
