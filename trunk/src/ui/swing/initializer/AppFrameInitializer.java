package ui.swing.initializer;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ui.action.ShowLoginDialogAction;
import ui.swing.util.ActionAdapter;

public class AppFrameInitializer {

	public JFrame frame() {
		JFrame frame = new JFrame();
		frame.setJMenuBar(menuBar(frame));
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return frame;
	}

	private JMenuBar menuBar(JFrame frame) {
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(initialMenu(frame));
		return menuBar;
	}

	private JMenu initialMenu(JFrame frame) {
		JMenu menu = new JMenu("Sistema");

		Action a = new ActionAdapter(new ShowLoginDialogAction(frame));
		menu.add(new JMenuItem(a));
		
		return menu;
	}

}
