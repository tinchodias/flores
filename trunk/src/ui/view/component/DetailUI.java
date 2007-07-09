package ui.view.component;

import ui.controller.action.Action;
import ui.controller.initializer.detail.mode.DetailMode;

public interface DetailUI extends DialogUI {

	void setAcceptAction(Action action);

	void setCancelAction(Action action);

	void setMode(DetailMode mode);
	
}
