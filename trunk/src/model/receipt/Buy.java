package model.receipt;

import model.JuridicPerson;
import model.money.Payment;
import model.money.Pesos;

import org.joda.time.ReadableDateTime;

public class Buy {

	private final BuyItems items;
	private final ReadableDateTime date;
	private final JuridicPerson supplier;
	private final Payment payment;
	private final Pesos buyTotal;
	private final Pesos paymentTotal;

	public Buy(BuyItems spec, ReadableDateTime date, JuridicPerson supplier, Payment payment) {
		this.items = spec;
		this.date = date;
		this.supplier = supplier;
		this.payment = payment;
		
		this.buyTotal = items.total();
		this.paymentTotal = payment.total();
	}

	public ReadableDateTime date() {
		return date;
	}

	public BuyItems items() {
		return items;
	}

	public Payment payment() {
		return payment;
	}

	public JuridicPerson supplier() {
		return supplier;
	}

	public Pesos buyTotal() {
		return buyTotal;
	}
	
	public Pesos paymentTotal() {
		return paymentTotal;
	}
	
}
