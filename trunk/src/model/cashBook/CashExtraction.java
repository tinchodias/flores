package model.cashBook;

import model.money.Pesos;

import org.joda.time.base.BaseDateTime;

public class CashExtraction {

	private final BaseDateTime date;
	private final Pesos amount;
	private final String note;

	public CashExtraction(BaseDateTime date, Pesos amount, String note) {
		this.date = date;
		this.amount = amount;
		this.note = note;
	}

	public BaseDateTime getDate() {
		return date;
	}

	public Pesos getAmount() {
		return amount;
	}

	public String getNote() {
		return note;
	}

}
