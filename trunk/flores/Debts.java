package model;

import java.util.HashMap;
import java.util.Map;

import model.money.Pesos;

public class Debts {

	private Map<JuridicPerson, Pesos> debts = new HashMap();

	public Pesos debtOf(JuridicPerson client) {
		Pesos debt = debts.get(client);
		return debt != null ? debt : Pesos.newFor(0.0);
	}
	
	public void applyIncome(JuridicPerson client, Pesos amount) {
		Pesos newDebt = Pesos.newFor(this.debtOf(client).value() + amount.value());
		debts.put(client, newDebt);
	}

	public void applyOutcome(JuridicPerson client, Pesos amount) {
		Pesos newDebt = Pesos.newFor(this.debtOf(client).value() - amount.value());
		debts.put(client, newDebt);
	}
}
