package ui.action;

import persistence.exception.MessageIdentifiedException;
import security.Security;
import ui.UI;
import ui.component.LoginUI;

public class LoginAction implements Action {

	private final LoginUI login;

	public LoginAction(LoginUI login) {
		this.login = login;
	}

	public void execute() {
		Security security = Security.instance();
		String name = login.getUserName();
		String password = login.getUserPassword();
		
		try {
			security.login(name, password);
		} catch (MessageIdentifiedException e1) {
			UI.instance().showInfo(e1.getMessage());
		}
	}

	public String getName() {
		return "Login";
	}
	
}
