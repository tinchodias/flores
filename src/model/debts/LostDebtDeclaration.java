package model.debts;


import message.MessageId;
import message.MessageRepository;
import model.JuridicPerson;
import model.money.MoneyAmount;

import org.joda.time.base.BaseDateTime;

import validation.ModelValidation;

public class LostDebtDeclaration {

	private final JuridicPerson client;
	private final MoneyAmount amount;
	private final BaseDateTime date;

	public LostDebtDeclaration(JuridicPerson client, MoneyAmount amount, BaseDateTime date) {
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

	public BaseDateTime getDate() {
		return date;
	}

	@Override
	public String toString() {
		return MessageRepository.instance().get(MessageId.lostDebtDeclarationToString, 
				new String[] {getClient().toString(), getAmount().toString()});
	}
	
}
