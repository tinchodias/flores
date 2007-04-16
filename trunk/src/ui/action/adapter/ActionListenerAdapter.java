package ui.action.adapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.action.ShowLoginDialogAction;

public class ActionListenerAdapter implements ActionListener {

	private final ShowLoginDialogAction action;

	public ActionListenerAdapter(ShowLoginDialogAction action) {
		this.action = action;
	}

	public void actionPerformed(ActionEvent e) {
		action.execute();
	}

}
