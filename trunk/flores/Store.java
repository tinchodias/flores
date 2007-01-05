package flores;

import java.util.Collection;
import java.util.HashSet;

import flores.receipt.Buy;
import flores.receipt.Sell;
import flores.stock.Stock;

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

	public Collection articles() {
		return articles;
	}

	public Clients clients() {
		return clients;
	}

	public Suppliers suppliers() {
		return suppliers;
	}

	public void add(Sell sell) {
		sells.add(sell);
		stock.apply(sell);
	}
}
