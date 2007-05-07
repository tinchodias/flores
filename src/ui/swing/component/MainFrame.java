package ui.swing.component;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ui.action.ShowClientsAction;
import ui.action.ShowLoginDialogAction;
import ui.component.MainUI;
import ui.swing.util.ActionAdapter;

public class MainFrame extends JFrame implements MainUI {

	private JMenu systemMenu;
	private JMenu storeMenu;

	public MainFrame() {
		setJMenuBar(newMenuBar());
		setSize(800, 600);
		setLocationRelativeTo(null);
		setInitialState();
	}
	
	private JMenuBar newMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(newSystemMenu());
		menuBar.add(newStoreMenu());
		return menuBar;
	}

	private Component newStoreMenu() {
		storeMenu = new JMenu("Dep�sito");

		ActionAdapter showClientsAction = new ActionAdapter(new ShowClientsAction());
		storeMenu.add(new JMenuItem(showClientsAction));
		
		return storeMenu;
	}

	private JMenu newSystemMenu() {
		systemMenu = new JMenu("Sesi�n");

		ActionAdapter loginAction = new ActionAdapter(new ShowLoginDialogAction());
		systemMenu.add(new JMenuItem(loginAction));
		
		return systemMenu;
	}
	
	public void setInitialState() {
		systemMenu.setEnabled(true);
		storeMenu.setEnabled(false);
	}
	
	public void setLoggedUserState() {
		systemMenu.setEnabled(false);
		storeMenu.setEnabled(true);
	}

}
