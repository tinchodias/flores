package flores.receipt;

import java.util.Collection;
import java.util.Date;

import money.Pay;

import flores.JuridicPerson;

public class Sell {
	private final ArticleSpecification specification;
	private final Date date;
	private final JuridicPerson client;
	private final Collection<Pay> payment;

	public Sell(ArticleSpecification spec, Date date, JuridicPerson client, Collection<Pay> payment) {
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

	public JuridicPerson getClient() {
		return client;
	}
	
	public Collection<Pay> getPayment() {
		return payment;
	}
}
