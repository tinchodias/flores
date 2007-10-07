package model.receipt;

import message.MessageId;
import model.JuridicPerson;
import model.Vendor;
import model.money.MoneyAmount;
import model.money.Payment;

import org.joda.time.base.BaseDateTime;

import validation.ModelValidation;


public class Sell {
	private final SellItems items;
	private final BaseDateTime date;
	private final JuridicPerson client;
	private final Payment payment;
	private final Vendor vendor;
	private final MoneyAmount sellTotal;
	private final MoneyAmount costTotal;
	private final MoneyAmount paymentTotal;

	public Sell(SellItems spec, BaseDateTime date, JuridicPerson client, Payment payment, Vendor vendor) {
		ModelValidation.instance().assertPositive((double) spec.size(), MessageId.itemCount);
		this.items = spec;
		this.date = date;
		ModelValidation.instance().assertNotNull(client, MessageId.client);
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

	public MoneyAmount clientDebt() {
		return items.sellTotal().minus(this.payment().total());
	}

	public Vendor vendor() {
		return vendor;
	}

	public MoneyAmount sellTotal() {
		return sellTotal;
	}

	public MoneyAmount costTotal() {
		return costTotal;
	}

	public MoneyAmount paymentTotal() {
		return paymentTotal;
	}
}
