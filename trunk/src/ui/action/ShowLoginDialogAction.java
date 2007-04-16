package ui.action;

import javax.swing.JDialog;
import javax.swing.JFrame;

import ui.initializer.LoginDialogInitializer;

public class ShowLoginDialogAction implements Action {

	private JFrame frame;

	public void execute() {
		JDialog dialog = new LoginDialogInitializer(frame).dialog();
		dialog.setVisible(true);
	}

}
