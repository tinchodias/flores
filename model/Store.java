package model;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

import model.commission.Commissions;
import model.debts.ClientsDebts;
import model.money.Payment;
import model.receipt.Buy;
import model.receipt.BuyAnnulment;
import model.receipt.Sell;
import model.receipt.SellAnnulment;
import model.stock.Article;
import model.stock.Stock;

//TODO Rethink this class.

//TODO Add validation checks to maintain consistency? 

public class Store {

	private Collection<Buy> buys = new HashSet();
	private Collection<Sell> sells = new HashSet();
	private Collection<BuyAnnulment> buyAnnulments = new HashSet();
	private Collection<SellAnnulment> sellAnnulments = new HashSet();
	private Collection<Article> articles = new HashSet();

	private Clients clients = new Clients(); 
	private Suppliers suppliers = new Suppliers();
	private Stock stock = new Stock();
	private ClientsDebts clientsDebts = new ClientsDebts();
	private Commissions commissions = new Commissions();
	private Vendors vendors = new Vendors();

	public Stock stock() {
		return stock;
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

	public Vendors vendors() {
		return vendors ;
	}

	public ClientsDebts debts() {
		return clientsDebts;
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

	public Commissions commissions() {
		return commissions;
	}
}
