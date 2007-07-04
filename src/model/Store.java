package model;

import java.util.Collection;
import java.util.HashSet;

import model.address.City;
import model.address.Province;
import model.commission.BasicCommissionsManager;
import model.commission.CommisionsManager;
import model.debts.ClientsDebts;
import model.receipt.Buy;
import model.receipt.BuyAnnulment;
import model.receipt.Expense;
import model.receipt.Sell;
import model.receipt.SellAnnulment;
import model.stock.Article;
import model.stock.ArticleGroup;
import model.stock.Stock;
import model.util.CollectionFactory;

import org.joda.time.ReadableInterval;

//TODO Rethink this class.

//TODO Add validation checks to maintain consistency? 

public class Store {

	private Collection<Buy> buys = CollectionFactory.newList();
	private Collection<Sell> sells = CollectionFactory.newList();
	private Collection<BuyAnnulment> buyAnnulments = CollectionFactory.newList();
	private Collection<SellAnnulment> sellAnnulments = CollectionFactory.newList();
	private Collection<Article> stockArticles = CollectionFactory.newList();
	private Collection<Article> expensesArticles = CollectionFactory.newList();
	private Collection<Expense> expenses = CollectionFactory.newList();
	private Collection<JuridicPerson> clients = CollectionFactory.newList(); 
	private Collection<JuridicPerson> suppliers = CollectionFactory.newList();
	private Collection<JuridicPerson> vendors = CollectionFactory.newList();
	private Collection<ArticleGroup> stockArticleGroups = CollectionFactory.newList();
	private Collection<Province> provinces = CollectionFactory.newList();
	private Collection<City> cities = CollectionFactory.newList();

	private Stock stock = new Stock();
	private ClientsDebts clientsDebts = new ClientsDebts(this);
	private CommisionsManager commissions = new BasicCommissionsManager(this);
	private CashBook cashBook = new CashBook();

	public Stock stock() {
		return stock;
	}

	public Collection<Article> stockArticles() {
		return stockArticles;
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
	
	public CashBook cashBook() {
		return cashBook;
	}

	public Iterable<Expense> expenses() {
		return expenses;
	}

	public Collection<ArticleGroup> stockArticleGroups() {
		return stockArticleGroups;
	}

	public Collection<Province> provinces() {
		return provinces;
	}

	public Collection<City> cities() {
		return cities;
	}

	public Iterable<Buy> buys() {
		return buys;
	}

	public Iterable<Sell> sells() {
		return sells;
	}

	public void add(Buy buy) {
		buys.add(buy);
		stock.apply(buy);
		cashBook.add(buy);
	}

	public void add(Sell sell) {
		sells.add(sell);
		stock.apply(sell);
		clientsDebts.apply(sell);
		cashBook.add(sell);
	}

	public void add(BuyAnnulment annulment) {
		buyAnnulments.add(annulment);
		stock.apply(annulment);
		cashBook.add(annulment);
	}

	public void add(SellAnnulment annulment) {
		sellAnnulments.add(annulment);
		stock.apply(annulment);
		clientsDebts.apply(annulment);
		cashBook.add(annulment);
	}

	public void add(Expense expense) {
		expenses.add(expense);
		cashBook.add(expense);
	}

	public Collection<Sell> sellsAt(JuridicPerson vendor, ReadableInterval lapse) {
		Collection<Sell> selection = new HashSet<Sell>();
		for (Sell sell : sells) {
			if (lapse.contains(sell.date()) && sell.vendor().equals(vendor)) {
				selection.add(sell);
			}
		}
		return selection;
	}

}
