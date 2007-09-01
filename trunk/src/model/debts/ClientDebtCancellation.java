package model.debts;

import model.JuridicPerson;
import model.money.Pesos;

import org.joda.time.base.BaseDateTime;

public class ClientDebtCancellation {

	private final JuridicPerson client;
	private final Pesos amount;
	private final BaseDateTime date;

	public ClientDebtCancellation(JuridicPerson client, Pesos amount, BaseDateTime date) {
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

	public BaseDateTime getDate() {
		return date;
	}

}
