package model.debts;

import model.JuridicPerson;
import model.money.MoneyAmount;

import org.joda.time.base.BaseDateTime;

public class ClientDebtCancellation {

	private final JuridicPerson client;
	private final MoneyAmount amount;
	private final BaseDateTime date;

	public ClientDebtCancellation(JuridicPerson client, MoneyAmount amount, BaseDateTime date) {
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

	public BaseDateTime getDate() {
		return date;
	}

}
