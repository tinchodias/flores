package ui.initializer;

import javax.swing.JDialog;
import javax.swing.JFrame;

import ui.action.LoginAction;
import ui.component.LoginDialog;

public class LoginDialogInitializer {

	private final JFrame frame;

	public LoginDialogInitializer(JFrame frame) {
		this.frame = frame;
	}

	public JDialog dialog() {
		LoginDialog loginDialog = new LoginDialog(frame);
		loginDialog.getLoginButton().setAction(new LoginAction(loginDialog));
		return loginDialog;
	}
	
}
