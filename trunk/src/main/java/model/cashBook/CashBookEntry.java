package model.cashBook;

import model.money.MoneyAmount;

import org.joda.time.base.BaseDateTime;

public class CashBookEntry {

	private final Object object;
	private final BaseDateTime date;
	private final MoneyAmount amount;

	public CashBookEntry(Object object, BaseDateTime date, MoneyAmount amount) {
		this.object = object;
		this.date = date;
		this.amount = amount;
	}

	public MoneyAmount getAmount() {
		return amount;
	}
	
	public BaseDateTime getDate() {
		return date;
	}
	
	public Object getObject() {
		return object;
	}
	
}
