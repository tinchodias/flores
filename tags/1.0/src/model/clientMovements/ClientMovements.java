package model.clientMovements;

import java.util.List;

import org.joda.time.base.BaseDateTime;

import model.JuridicPerson;
import model.debts.ClientDebtCancellation;
import model.debts.LostDebtDeclaration;
import model.receipt.Sell;
import model.receipt.SellCancellation;
import model.util.CollectionFactory;

public class ClientMovements {

	private List movements = CollectionFactory.newList();

	public List movements() {
		return movements;
	}
	
	public void apply(Sell sell) {
		add(sell.date(), sell.client(), sell);
	}

	public void apply(SellCancellation cancellation) {
		add(cancellation.getDate(), cancellation.getSell().client(), cancellation);
	}

	public void apply(LostDebtDeclaration declaration) {
		add(declaration.getDate(), declaration.getClient(), declaration);
	}

	public void apply(ClientDebtCancellation cancellation) {
		add(cancellation.getDate(), cancellation.getClient(), cancellation);
	}
	
	private void add(BaseDateTime date, JuridicPerson client, Object movement) {
		movements.add(new ClientMovement(date, client, movement));
	}

}
