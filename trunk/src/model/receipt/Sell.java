package model.receipt;

import model.JuridicPerson;
import model.money.Payment;
import model.money.Pesos;

import org.joda.time.ReadableDateTime;


public class Sell {
	private final SellItems items;
	private final ReadableDateTime date;
	private final JuridicPerson client;
	private final Payment payment;
	private final JuridicPerson vendor;

	public Sell(SellItems spec, ReadableDateTime date, JuridicPerson client, Payment payment, JuridicPerson vendor) {
		this.items = spec;
		this.date = date;
		this.client = client;
		this.payment = payment;
		this.vendor = vendor;
	}

	public SellItems items() {
		return items;
	}

	public ReadableDateTime date() {
		return date;
	}

	public JuridicPerson client() {
		return client;
	}
	
	public Payment payment() {
		return payment;
	}

	public Pesos clientDebt() {
		return items.sellTotal().minus(this.payment().total());
	}

	public JuridicPerson vendor() {
		return vendor;
	}

	public Pesos sellTotal() {
		return items.sellTotal();
	}

	public Pesos costTotal() {
		return items.costTotal();
	}
}
