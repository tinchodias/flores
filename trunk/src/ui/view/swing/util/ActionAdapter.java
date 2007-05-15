package ui.view.swing.util;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import ui.controller.action.Action;

public class ActionAdapter extends AbstractAction {

	private final Action action;

	public ActionAdapter(Action action) {
//		super(action.getTitle());
		super(null);
		this.action = action;
		this.putValue("hideActionText", true);
	}

	public void actionPerformed(ActionEvent e) {
		this.action.execute();
	}

}
