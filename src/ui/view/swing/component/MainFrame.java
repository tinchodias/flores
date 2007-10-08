package ui.view.swing.component;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import message.IconRepository;
import message.MessageId;
import message.MessageRepository;
import ui.controller.action.Action;
import ui.controller.action.ShowCurrentCashAction;
import ui.controller.action.ShowDialogAction;
import ui.controller.initializer.CommissionCalculationDialogInitializer;
import ui.controller.initializer.DialogInitializer;
import ui.controller.initializer.LoginDialogInitializer;
import ui.controller.initializer.search.ArticleGroupsDialogInitializer;
import ui.controller.initializer.search.BuysDialogInitializer;
import ui.controller.initializer.search.CashBookDialogInitializer;
import ui.controller.initializer.search.CashExtractionsDialogInitializer;
import ui.controller.initializer.search.CitiesDialogInitializer;
import ui.controller.initializer.search.ClientDebtCancellationsDialogInitializer;
import ui.controller.initializer.search.ClientsDialogInitializer;
import ui.controller.initializer.search.ExpensesArticlesDialogInitializer;
import ui.controller.initializer.search.ExpensesDialogInitializer;
import ui.controller.initializer.search.LostDebtDeclarationsDialogInitializer;
import ui.controller.initializer.search.PricePercentagesDialogInitializer;
import ui.controller.initializer.search.SellsDialogInitializer;
import ui.controller.initializer.search.StandardSearchDialogInitializer;
import ui.controller.initializer.search.StockDialogInitializer;
import ui.controller.initializer.search.StockDropOutsDialogInitializer;
import ui.controller.initializer.search.SuppliersDialogInitializer;
import ui.view.component.MainUI;
import ui.view.swing.util.actionadapter.ActionAdapter;

//TODO Remove Action instantiations from here.

public class MainFrame extends JFrame implements MainUI {

	private JMenu systemMenu;
	private JMenu personsMenu;
	private JMenu storeMenu;
	private JMenu cashMenu;

	public MainFrame() {
		setTitle(MessageRepository.instance().get(MessageId.mainTitle));
		
		ImageIcon icon = IconRepository.instance().get(MessageId.mainTitle);
		if (icon != null) {
			setIconImage(icon.getImage());
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setJMenuBar(newMenuBar());
//		setSize(800, 600);
		setSize(320, 200);
		setLocationRelativeTo(null);
		setInitialState();
	}
	
	private JMenuBar newMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(newSystemMenu());
		menuBar.add(newPersonsMenu());
		menuBar.add(newStoreMenu());
		menuBar.add(newCashMenu());
		return menuBar;
	}

	private Component newStoreMenu() {
		storeMenu = new JMenu("Stock");

		addJMenuItem(storeMenu, new BuysDialogInitializer());
		addJMenuItem(storeMenu, new SellsDialogInitializer());
		addJMenuItem(storeMenu, new StockDialogInitializer());
		addJMenuItem(storeMenu, new PricePercentagesDialogInitializer());
		addJMenuItem(storeMenu, new ArticleGroupsDialogInitializer());
		addJMenuItem(storeMenu, new StockDropOutsDialogInitializer());
		
		return storeMenu;
	}

	private Component newCashMenu() {
		cashMenu = new JMenu("Caja");

		addJMenuItem(cashMenu, new ShowCurrentCashAction());
		addJMenuItem(cashMenu, new CashBookDialogInitializer());
		addJMenuItem(cashMenu, new ExpensesArticlesDialogInitializer());
		addJMenuItem(cashMenu, new ExpensesDialogInitializer());
		addJMenuItem(cashMenu, new CashExtractionsDialogInitializer());
		addJMenuItem(cashMenu, new CommissionCalculationDialogInitializer(), MessageId.commissionCalculation);
		
		return cashMenu;
	}

	private Component newPersonsMenu() {
		personsMenu = new JMenu("Personas");

		addJMenuItem(personsMenu, new ClientsDialogInitializer());
		addJMenuItem(personsMenu, new SuppliersDialogInitializer());
		addJMenuItem(personsMenu, new CitiesDialogInitializer());
		addJMenuItem(personsMenu, new ClientDebtCancellationsDialogInitializer());
		addJMenuItem(personsMenu, new LostDebtDeclarationsDialogInitializer());
		
		return personsMenu;
	}

	private JMenu newSystemMenu() {
		systemMenu = new JMenu("Sesión");
		
		addJMenuItem(systemMenu, new LoginDialogInitializer(), MessageId.loginDialogTitle);
		
		return systemMenu;
	}
	
	private static void addJMenuItem(JMenu menu, DialogInitializer initializer, MessageId messageId) {
		addJMenuItem(menu, new ShowDialogAction(initializer, messageId));
	}

	private static void addJMenuItem(JMenu menu, StandardSearchDialogInitializer initializer) {
		addJMenuItem(menu, new ShowDialogAction(initializer, initializer.titleMessageId()));
	}
	
	private static void addJMenuItem(JMenu menu, Action action) {
		menu.add(new ActionAdapter(action));
	}

	public void setInitialState() {
		systemMenu.setEnabled(true);
		personsMenu.setEnabled(false);
		storeMenu.setEnabled(false);
		cashMenu.setEnabled(false);
	}
	
	public void setLoggedUserState() {
		systemMenu.setEnabled(false);
		personsMenu.setEnabled(true);
		storeMenu.setEnabled(true);
		cashMenu.setEnabled(true);
	}

}
