package model.debts;


import model.JuridicPerson;
import model.money.Pesos;

import org.joda.time.ReadableDateTime;

public class LostDebtDeclaration {

	private final JuridicPerson client;
	private final Pesos amount;
	private final ReadableDateTime date;

	public LostDebtDeclaration(JuridicPerson client, Pesos amount, ReadableDateTime date) {
		this.client = client;
		this.amount = amount;
		this.date = date;
	}

	public Pesos getAmount() {
		return amount;
	}

	public JuridicPerson getClient() {
		return client;
	}

	public ReadableDateTime getDate() {
		return date;
	}

}
