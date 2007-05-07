package ui.swing.component;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import message.MessageIdentifier;

import ui.UI;
import ui.action.Action;
import ui.component.LoginUI;
import ui.swing.util.ActionAdapter;
import ui.swing.util.StandardDialog;

public class LoginDialog extends StandardDialog implements LoginUI {

	private JTextField nameField;
	private JPasswordField passwordField;
	private JButton loginButton;
	
	public LoginDialog() {
		initComponents();
//		pack();
		//TODO Quitar este tamaño hardcoded!
		setSize(new Dimension(150, 120));
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		nameField = new JTextField("admin");
		passwordField = new JPasswordField();
		loginButton = new JButton();
		
		getRootPane().setDefaultButton(loginButton);

		centerPanel().add(UI.instance().label(nameField, MessageIdentifier.USER_NAME));
		centerPanel().add(UI.instance().label(passwordField, MessageIdentifier.USER_PASSWORD));
		buttonPanel().add(loginButton);
		
	}

	public String getUserName() {
		return nameField.getText();
	}

	public String getUserPassword() {
		return String.valueOf(passwordField.getPassword());
	}

	public void setLoginButtonAction(Action action) {
		loginButton.setAction(new ActionAdapter(action));
	}

}
