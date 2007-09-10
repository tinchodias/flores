package model.receipt;

import model.JuridicPerson;
import model.Vendor;
import model.money.Payment;
import model.money.Pesos;

import org.joda.time.base.BaseDateTime;


public class Sell {
	private final SellItems items;
	private final BaseDateTime date;
	private final JuridicPerson client;
	private final Payment payment;
	private final Vendor vendor;
	private final Pesos sellTotal;
	private final Pesos costTotal;
	private final Pesos paymentTotal;

	public Sell(SellItems spec, BaseDateTime date, JuridicPerson client, Payment payment, Vendor vendor) {
		this.items = spec;
		this.date = date;
		this.client = client;
		this.payment = payment;
		this.vendor = vendor;

		this.sellTotal = items.sellTotal();
		this.costTotal = items.costTotal();
		this.paymentTotal = payment.total();
	}

	public SellItems items() {
		return items;
	}

	public BaseDateTime date() {
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

	public Vendor vendor() {
		return vendor;
	}

	public Pesos sellTotal() {
		return sellTotal;
	}

	public Pesos costTotal() {
		return costTotal;
	}

	public Pesos paymentTotal() {
		return paymentTotal;
	}
}
