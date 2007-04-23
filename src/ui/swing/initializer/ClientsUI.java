package ui.swing.initializer;

import ui.action.Action;
import ui.component.DialogUI;
import ui.component.TableModelUI;

public interface ClientsUI extends DialogUI {

	public abstract void setOkButtonAction(Action action);

	public abstract void setAddClientButtonAction(Action action);

	public abstract void setModifyClientButtonAction(Action action);

	public abstract void setClients(TableModelUI model);
	
}
