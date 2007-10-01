package model.cashBook;

import message.MessageId;
import model.money.MoneyAmount;

import org.joda.time.base.BaseDateTime;

import validation.ModelValidation;

public class CashExtraction {

	private final BaseDateTime date;
	private final MoneyAmount amount;
	private final String note;

	public CashExtraction(BaseDateTime date, MoneyAmount amount, String note) {
		this.date = date;

		ModelValidation.instance().assertPositive(amount.value(), MessageId.moneyAmount);
		this.amount = amount;

		ModelValidation.instance().assertNotNull(note, MessageId.note);
		this.note = note;
	}

	public BaseDateTime getDate() {
		return date;
	}

	public MoneyAmount getAmount() {
		return amount;
	}

	public String getNote() {
		return note;
	}

}
