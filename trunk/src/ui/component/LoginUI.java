package ui.component;

import ui.action.Action;

public interface LoginUI {

	public abstract void setLoginButtonAction(Action a);

	public abstract String getUserName();

	public abstract String getUserPassword();

}