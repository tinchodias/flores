package model.receipt;

import message.MessageId;

import org.joda.time.base.BaseDateTime;

import validation.ModelValidation;

public class BuyCancellation {

	private final Buy buy;
	private final BaseDateTime date;

	public BuyCancellation(Buy buy, BaseDateTime date) {
		ModelValidation.instance().assertNotNull(buy, MessageId.buy);
		this.buy = buy;
		this.date = date;
	}

	public Buy getBuy() {
		return buy;
	}

	public BaseDateTime getDate() {
		return date;
	}

}
