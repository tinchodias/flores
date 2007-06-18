package ui.view.swing.component;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import message.MessageId;
import ui.controller.action.Action;
import ui.view.component.LoginUI;
import ui.view.swing.SwingUI;
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
		passwordField = new JPasswordField("123");
		loginButton = new JButton();
		
		getRootPane().setDefaultButton(loginButton);

		centerPanel().add(SwingUI.instance().label(nameField, MessageId.userName));
		centerPanel().add(SwingUI.instance().label(passwordField, MessageId.userPassword));
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
