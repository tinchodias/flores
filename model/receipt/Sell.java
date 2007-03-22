package model.receipt;

import model.JuridicPerson;
import model.money.Payment;
import model.money.Pesos;

import org.joda.time.ReadableDateTime;


public class Sell {
	private final SellArticleSpecification specification;
	private final ReadableDateTime date;
	private final JuridicPerson client;
	private final Payment payment;
	private final JuridicPerson vendor;

	public Sell(SellArticleSpecification spec, ReadableDateTime date, JuridicPerson client, Payment payment, JuridicPerson vendor) {
		this.specification = spec;
		this.date = date;
		this.client = client;
		this.payment = payment;
		this.vendor = vendor;
	}

	public SellArticleSpecification specification() {
		return specification;
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
		return specification.sellTotal().minus(this.payment().total());
	}

	public JuridicPerson vendor() {
		return vendor;
	}

	public Pesos sellTotal() {
		return specification.sellTotal();
	}

	public Pesos costTotal() {
		return specification.costTotal();
	}
}
