package ui.component;

import ui.action.Action;

public interface DetailUI extends DialogUI {

	public abstract void setCreateAction(Action action);

	public abstract void setModifyAction(Action action);

	public abstract void setCancelAction(Action action);
	
}
