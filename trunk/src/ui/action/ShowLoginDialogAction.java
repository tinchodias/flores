package ui.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JFrame;

import ui.initializer.LoginDialogInitializer;

public class ShowLoginDialogAction extends AbstractAction {

	private JFrame frame;

	public ShowLoginDialogAction(JFrame frame) {
		super("Login");
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent e) {
		JDialog dialog = new LoginDialogInitializer(frame).dialog();
		dialog.setVisible(true);
	}
	
}
