package ui.view.swing.util.actionadapter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import ui.controller.action.Action;

public class KeyTypedAdapter extends KeyAdapter {

	private final Action action;
	private final int key;

	public KeyTypedAdapter(Action action, int key) {
		this.action = action;
		this.key = key;
	}

	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == key) {
			action.execute();
		}
	}

}
