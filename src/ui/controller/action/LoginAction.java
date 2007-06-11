package ui.controller.action;

import message.MessageId;
import persistence.exception.MessageIdentifiedException;
import security.Security;
import ui.UI;
import ui.view.component.LoginUI;

public class LoginAction implements Action {

	private final LoginUI login;

	public LoginAction(LoginUI login) {
		this.login = login;
	}

	public void execute() {
		String name = login.getUserName();
		String password = login.getUserPassword();
		
		try {
			Security.instance().login(name, password);
			UI.instance().mainUI().setLoggedUserState();
			login.setVisible(false);
		} catch (MessageIdentifiedException e1) {
			UI.instance().showInfo(e1.getMessage());
		}
	}

	public MessageId messageId() {
		return MessageId.accept;
	}
	
}
