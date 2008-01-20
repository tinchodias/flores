package ui.view.component;

import ui.controller.action.Action;

public interface LoginUI extends DialogUI {

	public abstract void setLoginButtonAction(Action a);

	public abstract String getUserName();

	public abstract String getUserPassword();

}