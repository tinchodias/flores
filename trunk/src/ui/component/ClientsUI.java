package ui.component;

import ui.action.Action;

public interface ClientsUI extends DialogUI {

	public abstract void setOkButtonAction(Action action);

	public abstract void setAddClientButtonAction(Action action);

	public abstract void setModifyClientButtonAction(Action action);
	
}
