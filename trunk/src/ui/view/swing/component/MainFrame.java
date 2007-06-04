package ui.view.swing.component;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import message.MessageId;
import message.MessageRepository;
import ui.controller.action.ShowDialogAction;
import ui.controller.initializer.ClientsDialogInitializer;
import ui.controller.initializer.LoginDialogInitializer;
import ui.controller.initializer.StockDialogInitializer;
import ui.view.component.MainUI;
import ui.view.swing.util.ActionAdapter;

//TODO Remove Action instanciations from here.

public class MainFrame extends JFrame implements MainUI {

	private JMenu systemMenu;
	private JMenu storeMenu;

	public MainFrame() {
		setTitle(MessageRepository.instance().get(MessageId.mainTitle));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

		ActionAdapter showClientsAction = new ActionAdapter(new ShowDialogAction(new ClientsDialogInitializer(), MessageId.clientsDialogTitle));
		ActionAdapter showStockAction = new ActionAdapter(new ShowDialogAction(new StockDialogInitializer(), MessageId.stockDialogTitle));

		storeMenu.add(new JMenuItem(showClientsAction));
		storeMenu.add(new JMenuItem(showStockAction));
		
		return storeMenu;
	}

	private JMenu newSystemMenu() {
		systemMenu = new JMenu("Sesi�n");

		ActionAdapter loginAction = new ActionAdapter(new ShowDialogAction(new LoginDialogInitializer(), MessageId.loginDialogTitle));
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
