package ui.initializer;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ui.action.ShowLoginDialogAction;
import ui.action.adapter.ActionListenerAdapter;

public class AppFrameInitializer {

	public JFrame frame() {
		JFrame frame = new JFrame();
		frame.setJMenuBar(menuBar());
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return frame ;
	}

	private JMenuBar menuBar() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(initialMenu());
		return menuBar ;
	}

	private JMenu initialMenu() {
		JMenu menu = new JMenu("Sistema");
		menu.add(new JMenuItem("Login")).addActionListener(
				new ActionListenerAdapter(new ShowLoginDialogAction()));
//		menu.addSeparator();
//		menu.add(new JMenuItem("Salir")).addActionListener(
//				new ActionListenerAdapter(new ExitAction()));
		return menu;
	}

}
