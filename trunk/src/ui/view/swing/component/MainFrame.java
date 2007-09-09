package ui.view.swing.component;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import message.IconRepository;
import message.MessageId;
import message.MessageRepository;
import ui.controller.action.ShowDialogAction;
import ui.controller.initializer.DialogInitializer;
import ui.controller.initializer.LoginDialogInitializer;
import ui.controller.initializer.search.ArticleGroupsDialogInitializer;
import ui.controller.initializer.search.BuysDialogInitializer;
import ui.controller.initializer.search.CashBookDialogInitializer;
import ui.controller.initializer.search.CitiesDialogInitializer;
import ui.controller.initializer.search.ClientsDialogInitializer;
import ui.controller.initializer.search.ExpensesArticlesDialogInitializer;
import ui.controller.initializer.search.ExpensesDialogInitializer;
import ui.controller.initializer.search.PricePercentagesDialogInitializer;
import ui.controller.initializer.search.SellsDialogInitializer;
import ui.controller.initializer.search.StockDialogInitializer;
import ui.controller.initializer.search.StockDropOutsDialogInitializer;
import ui.controller.initializer.search.SuppliersDialogInitializer;
import ui.view.component.MainUI;
import ui.view.swing.util.actionadapter.ActionAdapter;

//TODO Remove Action instanciations from here.

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

		addJMenuItem(storeMenu, new BuysDialogInitializer(), MessageId.buys);
		addJMenuItem(storeMenu, new SellsDialogInitializer(), MessageId.sells);
		addJMenuItem(storeMenu, new StockDialogInitializer(), MessageId.stockDialogTitle);
		addJMenuItem(storeMenu, new PricePercentagesDialogInitializer(), MessageId.pricesDialogTitle);
		addJMenuItem(storeMenu, new ArticleGroupsDialogInitializer(), MessageId.articleGroups);
		addJMenuItem(storeMenu, new StockDropOutsDialogInitializer(), MessageId.stockDropOuts);
		
		return storeMenu;
	}

	private Component newCashMenu() {
		cashMenu = new JMenu("Caja");

		addJMenuItem(cashMenu, new CashBookDialogInitializer(), MessageId.cashBook);
		addJMenuItem(cashMenu, new ExpensesArticlesDialogInitializer(), MessageId.expensesArticles);
		addJMenuItem(cashMenu, new ExpensesDialogInitializer(), MessageId.expenses);
		
		return cashMenu;
	}

	private Component newPersonsMenu() {
		personsMenu = new JMenu("Personas");

		addJMenuItem(personsMenu, new ClientsDialogInitializer(), MessageId.clients);
		addJMenuItem(personsMenu, new SuppliersDialogInitializer(), MessageId.suppliers);
		addJMenuItem(personsMenu, new CitiesDialogInitializer(), MessageId.cities);
		
		return personsMenu;
	}

	private JMenu newSystemMenu() {
		systemMenu = new JMenu("Sesi�n");
		
		addJMenuItem(systemMenu, new LoginDialogInitializer(), MessageId.loginDialogTitle);
		
		return systemMenu;
	}
	
	private static void addJMenuItem(JMenu menu, DialogInitializer initializer, MessageId messageId) {
		menu.add(new ActionAdapter(new ShowDialogAction(initializer, messageId)));
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
