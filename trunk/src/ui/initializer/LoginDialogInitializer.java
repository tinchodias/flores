package ui.initializer;

import javax.swing.JDialog;
import javax.swing.JFrame;

import ui.component.LoginDialog;

public class LoginDialogInitializer {

	private final JFrame frame;

	public LoginDialogInitializer(JFrame frame) {
		this.frame = frame;
	}

	public JDialog dialog() {
		return new LoginDialog(frame);
	}
	
}
