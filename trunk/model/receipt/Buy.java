package model.receipt;

import java.util.Date;

import model.JuridicPerson;
import model.money.Payment;

public class Buy {

	private final ArticleSpecification specification;
	private final Date date;
	private final JuridicPerson supplier;
	private final Payment payment;

	public Buy(ArticleSpecification spec, Date date, JuridicPerson supplier, Payment payment) {
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

	public Payment getPayment() {
		return payment;
	}

	public JuridicPerson getSupplier() {
		return supplier;
	}

}
