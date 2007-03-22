package model.commission;

import java.util.Collection;

import model.JuridicPerson;
import model.Store;
import model.money.Pesos;
import model.receipt.Expense;
import model.receipt.Sell;

import org.joda.time.Interval;

public class BasicCommissionsManager implements CommisionsManager {
	
	private final Store store;
	private double commisionAlpha;

	public BasicCommissionsManager(Store store) {
		this.store = store;
		this.commisionAlpha = 0.5;
	}

	/* (non-Javadoc)
	 * @see model.commission.ICommision#commissionAt(model.JuridicPerson, org.joda.time.Interval)
	 */
	public CommissionSummary commissionAt(JuridicPerson vendor, Interval lapse) {
		Collection<Sell> sells = store.sellsAt(vendor, lapse);
		
		Pesos sellTotal = sellTotal(sells);
		Pesos costTotal = costTotal(sells);
		Pesos expensesTotal = expensesTotal(); 
		
		Pesos commision = commision(sellTotal, costTotal, expensesTotal);
		
		return new CommissionSummary(vendor, lapse, sellTotal, costTotal, expensesTotal, commision);
	}

	private Pesos commision(Pesos sellTotal, Pesos costTotal, Pesos expensesTotal) {
		return sellTotal.minus(costTotal.plus(expensesTotal)).by(commisionAlpha);
	}

	private Pesos expensesTotal() {
		Pesos total = Pesos.newFor(0.0);
		for (Expense expense : store.expenses()) {
			total = total.plus(expense.getCost());
		}
		return total;
	}

	private Pesos sellTotal(Collection<Sell> sells) {
		Pesos total = Pesos.newFor(0.0);
		for (Sell sell : sells) {
			total = total.plus(sell.sellTotal());
		}
		return total;
	}

	private Pesos costTotal(Collection<Sell> sells) {
		Pesos total = Pesos.newFor(0.0);
		for (Sell sell : sells) {
			total = total.plus(sell.costTotal());
		}
		return total;
	}
}
