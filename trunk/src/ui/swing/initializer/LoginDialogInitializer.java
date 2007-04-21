package ui.swing.initializer;

import java.awt.Dialog.ModalityType;

import javax.swing.JDialog;
import javax.swing.JFrame;

import ui.action.LoginAction;
import ui.swing.component.LoginPanel;

public class LoginDialogInitializer {

	private final JFrame frame;

	public LoginDialogInitializer(JFrame frame) {
		this.frame = frame;
	}

	public JDialog dialog() {
		LoginPanel panel = new LoginPanel();
		panel.setLoginButtonAction(new LoginAction(panel));
		
		JDialog loginDialog = new JDialog(frame, ModalityType.APPLICATION_MODAL);
		loginDialog.add(panel);
		
		loginDialog.pack();
		
		return loginDialog;
	}
	
}
