package ui.swing.component;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ui.action.Action;
import ui.component.LoginUI;
import ui.swing.util.ActionAdapter;
import ui.swing.util.LabeledPanel;
import ui.swing.util.StandardDialog;

public class LoginDialog extends StandardDialog implements LoginUI {

	private LabeledPanel nameField;
	private LabeledPanel passwordField;
	private JButton loginButton;
	
	public LoginDialog() {
		super();
		initComponents();
		pack();
	}

	private void initComponents() {
		nameField = new LabeledPanel(new JTextField("admin"));
		passwordField = new LabeledPanel(new JPasswordField());
		loginButton = new JButton();
		loginButton.setDefaultCapable(true);
		
		nameField.setTitle("Nombre:");
		passwordField.setTitle("Clave:");
		loginButton.setPreferredSize(new Dimension(100, 30));

		centerPanel().add(nameField);
		centerPanel().add(passwordField);
		buttonPanel().add(loginButton);
	}

	public String getUserName() {
		return ((JTextField) nameField.getComponent()).getText();
	}

	public String getUserPassword() {
		return String.valueOf(((JPasswordField) passwordField.getComponent()).getPassword());
	}

	public void setLoginButtonAction(Action action) {
		loginButton.setAction(new ActionAdapter(action));
	}

}
