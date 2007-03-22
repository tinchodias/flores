package model.receipt;

import model.JuridicPerson;
import model.money.Payment;

import org.joda.time.ReadableDateTime;

public class Buy {

	private final BuyArticleSpecification specification;
	private final ReadableDateTime date;
	private final JuridicPerson supplier;
	private final Payment payment;

	public Buy(BuyArticleSpecification spec, ReadableDateTime date, JuridicPerson supplier, Payment payment) {
		this.specification = spec;
		this.date = date;
		this.supplier = supplier;
		this.payment = payment;
	}

	public ReadableDateTime date() {
		return date;
	}

	public BuyArticleSpecification specification() {
		return specification;
	}

	public Payment getPayment() {
		return payment;
	}

	public JuridicPerson getSupplier() {
		return supplier;
	}

}
