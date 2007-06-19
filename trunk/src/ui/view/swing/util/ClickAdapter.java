package ui.view.swing.util;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ui.controller.action.Action;

public class ClickAdapter implements MouseListener {

	private final Action action;
	private final int clickCount;

	public ClickAdapter(Action action, int clickCount) {
		this.action = action;
		this.clickCount = clickCount;
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == clickCount) {
			action.execute();
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}
	
}
