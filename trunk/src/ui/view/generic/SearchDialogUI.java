package ui.view.component;

import ui.controller.action.Action;

public interface SearchDialogUI extends DialogUI {

	public abstract void setCloseAction(Action action);

	public abstract void add(Action action);
	
	public abstract SearchUI getSearchPanel(); 
}
