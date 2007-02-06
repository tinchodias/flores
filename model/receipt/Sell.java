package model.receipt;

import java.util.Date;

import model.JuridicPerson;
import model.money.Payment;
import model.money.Pesos;


public class Sell {
	private final ArticleSpecification specification;
	private final Date date;
	private final JuridicPerson client;
	private final Payment payment;

	public Sell(ArticleSpecification spec, Date date, JuridicPerson client, Payment payment) {
		this.specification = spec;
		this.date = date;
		this.client = client;
		this.payment = payment;
	}

	public ArticleSpecification specification() {
		return specification;
	}

	public Date date() {
		return date;
	}

	public JuridicPerson client() {
		return client;
	}
	
	public Payment payment() {
		return payment;
	}

	public Pesos clientDebt() {
		return specification.total().minus(this.payment().total());
	}
}
