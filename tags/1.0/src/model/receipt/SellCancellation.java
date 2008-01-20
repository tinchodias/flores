package model.receipt;

import message.MessageId;

import org.joda.time.base.BaseDateTime;

import validation.ModelValidation;


public class SellCancellation {

	private final BaseDateTime date;
	private final Sell sell;

	public SellCancellation(Sell sell, BaseDateTime date) {
		ModelValidation.instance().assertNotNull(sell, MessageId.sell);
		this.sell = sell;
		this.date = date;
	}

	public BaseDateTime getDate() {
		return date;
	}

	public Sell getSell() {
		return sell;
	}

}
