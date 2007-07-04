package model;

import model.money.Pesos;

import org.joda.time.ReadableDateTime;

public class CashBookEntry {

	private final Object object;
	private final ReadableDateTime date;
	private final Pesos amount;

	public CashBookEntry(Object object, ReadableDateTime date, Pesos amount) {
		this.object = object;
		this.date = date;
		this.amount = amount;
	}

	public Pesos getAmount() {
		return amount;
	}
	
	public ReadableDateTime getDate() {
		return date;
	}
	
	public Object getObject() {
		return object;
	}
	
}
