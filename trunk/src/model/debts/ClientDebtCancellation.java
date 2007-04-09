package model.debts;

import model.JuridicPerson;
import model.money.Pesos;

import org.joda.time.ReadableDateTime;

public class ClientDebtCancellation {

	private final JuridicPerson client;
	private final Pesos amount;
	private final ReadableDateTime date;

	public ClientDebtCancellation(JuridicPerson client, Pesos amount, ReadableDateTime date) {
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
