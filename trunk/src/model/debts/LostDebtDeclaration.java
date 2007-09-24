package model.debts;


import model.JuridicPerson;
import model.money.MoneyAmount;

import org.joda.time.ReadableDateTime;

public class LostDebtDeclaration {

	private final JuridicPerson client;
	private final MoneyAmount amount;
	private final ReadableDateTime date;

	public LostDebtDeclaration(JuridicPerson client, MoneyAmount amount, ReadableDateTime date) {
		this.client = client;
		this.amount = amount;
		this.date = date;
	}

	public MoneyAmount getAmount() {
		return amount;
	}

	public JuridicPerson getClient() {
		return client;
	}

	public ReadableDateTime getDate() {
		return date;
	}

}
