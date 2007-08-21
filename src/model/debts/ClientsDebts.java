package model.debts;

import java.util.Collection;
import java.util.Map;

import model.JuridicPerson;
import model.Store;
import model.money.Pesos;
import model.receipt.Sell;
import model.receipt.SellCancellation;
import model.util.CollectionFactory;

public class ClientsDebts {

	private Map<JuridicPerson, Pesos> debts = CollectionFactory.<JuridicPerson, Pesos>newMap();
	private Collection<LostDebtDeclaration> declarations = CollectionFactory.<LostDebtDeclaration>newList();
	private Collection<ClientDebtCancellation> cancellations = CollectionFactory.<ClientDebtCancellation>newList();
	private final Store store;

	public ClientsDebts(Store store) {
		this.store = store;
	}

	public Pesos debtOf(JuridicPerson client) {
		Pesos debt = debts.get(client);
		return debt != null ? debt : Pesos.newFor(0.0);
	}
	
	private void incrementDebt(JuridicPerson client, Pesos amount) {
		Pesos newDebt = Pesos.newFor(this.debtOf(client).value() + amount.value());
		debts.put(client, newDebt);
	}
	
	private void reduceDebt(JuridicPerson client, Pesos amount) {
		Pesos newDebt = Pesos.newFor(this.debtOf(client).value() - amount.value());
		debts.put(client, newDebt);
	}

	public void add(LostDebtDeclaration declaration) {
		declarations.add(declaration);
		reduceDebt(declaration.getClient(), declaration.getAmount());
	}

	public void add(ClientDebtCancellation cancellation) {
		cancellations.add(cancellation);
		reduceDebt(cancellation.getClient(), cancellation.getAmount());
		store.cashBook().add(cancellation);
	}

	public void apply(Sell sell) {
		incrementDebt(sell.client(), sell.clientDebt());
	}

	public void apply(SellCancellation cancellation) {
		reduceDebt(cancellation.getSell().client(), cancellation.getSell().clientDebt());
	}
}
