package ui.view.swing.component;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import message.MessageId;
import message.MessageRepository;
import ui.controller.action.ShowDialogAction;
import ui.controller.initializer.BuysDialogInitializer;
import ui.controller.initializer.CitiesDialogInitializer;
import ui.controller.initializer.ClientsDialogInitializer;
import ui.controller.initializer.LoginDialogInitializer;
import ui.controller.initializer.StockDialogInitializer;
import ui.controller.initializer.StockDropOutsDialogInitializer;
import ui.controller.initializer.SuppliersDialogInitializer;
import ui.view.component.MainUI;
import ui.view.swing.util.ActionAdapter;

//TODO Remove Action instanciations from here.

public class MainFrame extends JFrame implements MainUI {

	private JMenu systemMenu;
	private JMenu personsMenu;
	private JMenu storeMenu;

	public MainFrame() {
		setTitle(MessageRepository.instance().get(MessageId.mainTitle));
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setJMenuBar(newMenuBar());
		setSize(800, 600);
		setLocationRelativeTo(null);
		setInitialState();
	}
	
	private JMenuBar newMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(newSystemMenu());
		menuBar.add(newPersonsMenu());
		menuBar.add(newStoreMenu());
		return menuBar;
	}

	private Component newStoreMenu() {
		storeMenu = new JMenu("Depósito");

		ActionAdapter showStockAction = new ActionAdapter(new ShowDialogAction(new StockDialogInitializer(), MessageId.stockDialogTitle));
		ActionAdapter showStockDropDownsAction = new ActionAdapter(new ShowDialogAction(new StockDropOutsDialogInitializer(), MessageId.stockDropOutsDialogTitle));
		ActionAdapter showBuysAction = new ActionAdapter(new ShowDialogAction(new BuysDialogInitializer(), MessageId.buysDialogTitle));

		storeMenu.add(new JMenuItem(showStockAction));
		storeMenu.add(new JMenuItem(showStockDropDownsAction));
		storeMenu.add(new JMenuItem(showBuysAction));
		
		return storeMenu;
	}

	private Component newPersonsMenu() {
		personsMenu = new JMenu("Personas");

		ActionAdapter showClientsAction = new ActionAdapter(new ShowDialogAction(new ClientsDialogInitializer(), MessageId.clientsDialogTitle));
		ActionAdapter showSuppliersAction = new ActionAdapter(new ShowDialogAction(new SuppliersDialogInitializer(), MessageId.suppliersDialogTitle));
		ActionAdapter showCitiesAction = new ActionAdapter(new ShowDialogAction(new CitiesDialogInitializer(), MessageId.citiesDialogTitle));

		personsMenu.add(new JMenuItem(showClientsAction));
		personsMenu.add(new JMenuItem(showSuppliersAction));
		personsMenu.add(new JMenuItem(showCitiesAction));
		
		return personsMenu;
	}

	private JMenu newSystemMenu() {
		systemMenu = new JMenu("Sesión");

		ActionAdapter loginAction = new ActionAdapter(new ShowDialogAction(new LoginDialogInitializer(), MessageId.loginDialogTitle));
		systemMenu.add(new JMenuItem(loginAction));
		
		return systemMenu;
	}
	
	public void setInitialState() {
		systemMenu.setEnabled(true);
		personsMenu.setEnabled(false);
		storeMenu.setEnabled(false);
	}
	
	public void setLoggedUserState() {
		systemMenu.setEnabled(false);
		personsMenu.setEnabled(true);
		storeMenu.setEnabled(true);
	}

}
