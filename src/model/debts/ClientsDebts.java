package model.debts;

import java.util.Collection;
import java.util.Map;

import model.JuridicPerson;
import model.Store;
import model.money.MoneyAmount;
import model.receipt.Sell;
import model.receipt.SellCancellation;
import model.util.CollectionFactory;

public class ClientsDebts {

	private Map<JuridicPerson, MoneyAmount> debts = CollectionFactory.<JuridicPerson, MoneyAmount>newIdentityMap();
	private Collection<LostDebtDeclaration> declarations = CollectionFactory.<LostDebtDeclaration>newList();
	private Collection<ClientDebtCancellation> cancellations = CollectionFactory.<ClientDebtCancellation>newList();
	private final Store store;

	public ClientsDebts(Store store) {
		this.store = store;
	}
	
	public Iterable<LostDebtDeclaration> declarations() {
		return declarations;
	}

	public Iterable<ClientDebtCancellation> cancellations() {
		return cancellations;
	}
	
	public MoneyAmount debtOf(JuridicPerson client) {
		MoneyAmount debt = debts.get(client);
		return debt != null ? debt : MoneyAmount.zero();
	}
	
	private void incrementDebt(JuridicPerson client, MoneyAmount amount) {
		MoneyAmount newDebt = MoneyAmount.newFor(this.debtOf(client).value() + amount.value());
		debts.put(client, newDebt);
	}
	
	private void reduceDebt(JuridicPerson client, MoneyAmount amount) {
		MoneyAmount newDebt = MoneyAmount.newFor(this.debtOf(client).value() - amount.value());
		debts.put(client, newDebt);
	}

	public void add(LostDebtDeclaration declaration) {
		declarations.add(declaration);
		reduceDebt(declaration.getClient(), declaration.getAmount());
		store.clientMovements().apply(declaration);
	}

	public void add(ClientDebtCancellation cancellation) {
		cancellations.add(cancellation);
		reduceDebt(cancellation.getClient(), cancellation.getAmount());
		store.cashBook().apply(cancellation);
		store.clientMovements().apply(cancellation);
	}

	public void apply(Sell sell) {
		incrementDebt(sell.client(), sell.clientDebt());
	}

	public void apply(SellCancellation cancellation) {
		reduceDebt(cancellation.getSell().client(), cancellation.getSell().clientDebt());
	}
}
