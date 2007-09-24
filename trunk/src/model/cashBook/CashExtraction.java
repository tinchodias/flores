package model.cashBook;

import model.money.MoneyAmount;

import org.joda.time.base.BaseDateTime;

public class CashExtraction {

	private final BaseDateTime date;
	private final MoneyAmount amount;
	private final String note;

	public CashExtraction(BaseDateTime date, MoneyAmount amount, String note) {
		this.date = date;
		this.amount = amount;
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
