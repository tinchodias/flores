package model;

import java.util.Collection;
import java.util.HashSet;

import model.debts.Debts;
import model.receipt.Buy;
import model.receipt.Sell;
import model.stock.Stock;


public class Store {

	private Stock stock = new Stock();
	private Collection buys = new HashSet();
	private Collection sells = new HashSet();
	private Collection articles = new HashSet();
	private Clients clients = new Clients(); 
	private Suppliers suppliers = new Suppliers();
	private Debts debts = new Debts();

	public Stock stock() {
		return stock;
	}

	public void add(Buy buy) {
		buys.add(buy);
		stock.apply(buy);
	}

	public Collection<Article> articles() {
		return articles;
	}

	public Clients clients() {
		return clients;
	}

	public Suppliers suppliers() {
		return suppliers;
	}

	public Debts debts() {
		return debts;
	}
	
	public void add(Sell sell) {
		sells.add(sell);
		stock.apply(sell);
		debts.apply(sell);
	}
}
