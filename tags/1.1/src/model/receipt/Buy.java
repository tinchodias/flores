package model.receipt;

import message.MessageId;
import model.JuridicPerson;
import model.money.MoneyAmount;
import model.money.Payment;

import org.joda.time.base.BaseDateTime;

import validation.ModelValidation;

public class Buy {

	private final BuyItems items;
	private final BaseDateTime date;
	private final JuridicPerson supplier;
	private final Payment payment;
	private final MoneyAmount buyTotal;
	private final MoneyAmount paymentTotal;

	public Buy(BuyItems spec, BaseDateTime date, JuridicPerson supplier, Payment payment) {
		ModelValidation.instance().assertPositive((double) spec.size(), MessageId.itemCount);
		this.items = spec;
		this.date = date;
		ModelValidation.instance().assertNotNull(supplier, MessageId.supplier);
		this.supplier = supplier;
		this.payment = payment;
		
		this.buyTotal = items.total();
		this.paymentTotal = payment.total();
	}

	public BaseDateTime date() {
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

	public MoneyAmount buyTotal() {
		return buyTotal;
	}
	
	public MoneyAmount paymentTotal() {
		return paymentTotal;
	}
	
}
