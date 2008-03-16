package ui.view.swing.util.actionadapter;

import ui.controller.action.Action;
import ui.view.swing.util.objectpicker.SelectionListener;

public class SelectionListenerAdapter implements SelectionListener {

	private final Action action;

	public SelectionListenerAdapter(Action action) {
		this.action = action;
	}

	public void selected(Object selection) {
		action.execute();
	}

}
