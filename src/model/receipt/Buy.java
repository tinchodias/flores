package model.receipt;

import model.JuridicPerson;
import model.money.Payment;

import org.joda.time.ReadableDateTime;

public class Buy {

	private final BuyItems items;
	private final ReadableDateTime date;
	private final JuridicPerson supplier;
	private final Payment payment;

	public Buy(BuyItems spec, ReadableDateTime date, JuridicPerson supplier, Payment payment) {
		this.items = spec;
		this.date = date;
		this.supplier = supplier;
		this.payment = payment;
	}

	public ReadableDateTime date() {
		return date;
	}

	public BuyItems items() {
		return items;
	}

	public Payment getPayment() {
		return payment;
	}

	public JuridicPerson getSupplier() {
		return supplier;
	}

}
