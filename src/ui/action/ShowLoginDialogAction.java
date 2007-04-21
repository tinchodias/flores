package ui.action;

import javax.swing.JDialog;
import javax.swing.JFrame;

import ui.swing.initializer.LoginDialogInitializer;

public class ShowLoginDialogAction implements Action {

	private JFrame frame;

	public ShowLoginDialogAction(JFrame frame) {
		this.frame = frame;
	}

	public void execute() {
		JDialog dialog = new LoginDialogInitializer(frame).dialog();
		dialog.setVisible(true);
	}

	public String getName() {
		return "Mostrar Login";
	}
	
}
