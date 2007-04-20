package ui.component;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginDialog extends JDialog {

	private LabeledPanel nameField;
	private LabeledPanel passwordField;
	private JButton loginButton;
	private JPanel centerPanel;

	public LoginDialog(JFrame frame) {
		super(frame);
		init();
		initComponents();
		pack();
//		this.setLocationRelativeTo(frame);
	}

	private void init() {
		this.setModal(true);
		this.setLayout(new BorderLayout());
	}

	private void initComponents() {
		nameField = new LabeledPanel(new JTextField("martin"));
		passwordField = new LabeledPanel(new JPasswordField("123456"));
		loginButton = new JButton("Aceptar");
		
		centerPanel = new JPanel();
		centerPanel.add(nameField);
		centerPanel.add(passwordField);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(loginButton, BorderLayout.SOUTH);

		setTitle("Login");
		nameField.setTitle("Nombre:");
		passwordField.setTitle("Clave:");
		loginButton.setText("Aceptar");
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	public JPanel getCenterPanel() {
		return centerPanel;
	}

	public LabeledPanel getNameField() {
		return nameField;
	}

	public LabeledPanel getPasswordField() {
		return passwordField;
	}

}
