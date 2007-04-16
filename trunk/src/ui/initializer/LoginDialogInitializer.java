package ui.initializer;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class LoginDialogInitializer {

	private final JFrame frame;

	public LoginDialogInitializer(JFrame frame) {
		this.frame = frame;
	}

	public JDialog dialog() {
		JDialog dialog = new JDialog(frame, "Login");
		dialog.setSize(300, 200);
		dialog.setModal(true);
		return dialog;
	}
	
}
