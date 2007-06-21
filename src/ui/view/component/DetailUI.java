package ui.view.component;

import ui.controller.action.Action;

public interface DetailUI extends DialogUI {

	public abstract void setAcceptAction(Action action);

	public abstract void setCancelAction(Action action);
	
}
