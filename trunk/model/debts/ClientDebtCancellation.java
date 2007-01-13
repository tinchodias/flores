package model.debts;

import java.util.Date;

import model.JuridicPerson;
import model.money.Pesos;

public class ClientDebtCancellation {

	private final JuridicPerson client;
	private final Pesos amount;
	private final Date date;

	public ClientDebtCancellation(JuridicPerson client, Pesos amount, Date date) {
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

	public Date getDate() {
		return date;
	}

}
