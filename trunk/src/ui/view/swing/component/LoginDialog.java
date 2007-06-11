package ui.view.swing.component;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import message.MessageId;
import ui.UI;
import ui.controller.action.Action;
import ui.view.component.LoginUI;
import ui.view.swing.util.ActionAdapter;
import ui.view.swing.util.StandardDialog;

public class LoginDialog extends StandardDialog implements LoginUI {

	private JTextField nameField;
	private JPasswordField passwordField;
	private JButton loginButton;
	
	public LoginDialog() {
		super(MessageId.loginDialogTitle);
		
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		nameField = new JTextField("admin");
		passwordField = new JPasswordField();
		loginButton = new JButton();
		
		getRootPane().setDefaultButton(loginButton);

		centerPanel().add(UI.instance().label(nameField, MessageId.userName));
		centerPanel().add(UI.instance().label(passwordField, MessageId.userPassword));
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
