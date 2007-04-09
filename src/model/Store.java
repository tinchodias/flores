package model;

import java.util.Collection;
import java.util.HashSet;

import model.commission.BasicCommissionsManager;
import model.commission.CommisionsManager;
import model.debts.ClientsDebts;
import model.receipt.Buy;
import model.receipt.BuyAnnulment;
import model.receipt.Expense;
import model.receipt.Sell;
import model.receipt.SellAnnulment;
import model.stock.Article;
import model.stock.Stock;
import model.util.CollectionFactory;

import org.joda.time.Interval;

//TODO Rethink this class.

//TODO Add validation checks to maintain consistency? 

public class Store {

	private Collection<Buy> buys = CollectionFactory.newSet();
	private Collection<Sell> sells = CollectionFactory.newSet();
	private Collection<BuyAnnulment> buyAnnulments = CollectionFactory.newSet();
	private Collection<SellAnnulment> sellAnnulments = CollectionFactory.newSet();
	private Collection<Article> articles = CollectionFactory.newSet();
	private Collection<Article> expensesArticles = CollectionFactory.newSet();
	private Collection<Expense> expenses = CollectionFactory.newSet();
	private Collection<JuridicPerson> clients = CollectionFactory.newSet(); 
	private Collection<JuridicPerson> suppliers = CollectionFactory.newSet();
	private Collection<JuridicPerson> vendors = CollectionFactory.newSet();

	private Stock stock = new Stock();
	private ClientsDebts clientsDebts = new ClientsDebts();
	private CommisionsManager commissions = new BasicCommissionsManager(this);

	public Stock stock() {
		return stock;
	}

	public Collection<Article> productArticles() {
		return articles;
	}

	public Collection<Article> expensesArticles() {
		return expensesArticles;
	}
	
	public Collection<JuridicPerson> clients() {
		return clients;
	}

	public Collection<JuridicPerson> suppliers() {
		return suppliers;
	}

	public Collection<JuridicPerson> vendors() {
		return vendors ;
	}

	public ClientsDebts debts() {
		return clientsDebts;
	}

	public CommisionsManager commissions() {
		return commissions;
	}
	
	public Collection<Expense> expenses() {
		return expenses;
	}

	public void add(Buy buy) {
		buys.add(buy);
		stock.apply(buy);
	}

	public void add(Sell sell) {
		sells.add(sell);
		stock.apply(sell);
		clientsDebts.apply(sell);
	}

	public void add(BuyAnnulment annulment) {
		buyAnnulments.add(annulment);
		stock.apply(annulment);
	}

	public void add(SellAnnulment annulment) {
		sellAnnulments.add(annulment);
		stock.apply(annulment);
		clientsDebts.apply(annulment);
	}

	public Collection<Sell> sellsAt(JuridicPerson vendor, Interval lapse) {
		Collection<Sell> selection = new HashSet<Sell>();
		for (Sell sell : sells) {
			if (lapse.contains(sell.date()) && sell.vendor().equals(vendor)) {
				selection.add(sell);
			}
		}
		return selection;
	}
}
