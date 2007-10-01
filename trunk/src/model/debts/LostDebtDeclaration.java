package model.debts;


import message.MessageId;
import model.JuridicPerson;
import model.money.MoneyAmount;

import org.joda.time.ReadableDateTime;

import validation.ModelValidation;

public class LostDebtDeclaration {

	private final JuridicPerson client;
	private final MoneyAmount amount;
	private final ReadableDateTime date;

	public LostDebtDeclaration(JuridicPerson client, MoneyAmount amount, ReadableDateTime date) {
		ModelValidation.instance().assertNotNull(client, MessageId.client);
		this.client = client;
		
		ModelValidation.instance().assertPositive(amount.value(), MessageId.moneyAmount);
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
