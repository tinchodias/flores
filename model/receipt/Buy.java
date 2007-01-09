package model.receipt;

import java.util.Collection;
import java.util.Date;

import model.JuridicPerson;
import model.money.Pay;

public class Buy {

	private final ArticleSpecification specification;
	private final Date date;
	private final JuridicPerson supplier;
	private final Collection<Pay> payment;

	public Buy(ArticleSpecification spec, Date date, JuridicPerson supplier, Collection<Pay> payment) {
		this.specification = spec;
		this.date = date;
		this.supplier = supplier;
		this.payment = payment;
	}

	public Date date() {
		return date;
	}

	public ArticleSpecification specification() {
		return specification;
	}

	public Collection<Pay> getPayment() {
		return payment;
	}

	public JuridicPerson getSupplier() {
		return supplier;
	}

}
