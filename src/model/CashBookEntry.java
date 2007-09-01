package model;

import model.money.Pesos;

import org.joda.time.base.BaseDateTime;

public class CashBookEntry {

	private final Object object;
	private final BaseDateTime date;
	private final Pesos amount;

	public CashBookEntry(Object object, BaseDateTime date, Pesos amount) {
		this.object = object;
		this.date = date;
		this.amount = amount;
	}

	public Pesos getAmount() {
		return amount;
	}
	
	public BaseDateTime getDate() {
		return date;
	}
	
	public Object getObject() {
		return object;
	}
	
}
