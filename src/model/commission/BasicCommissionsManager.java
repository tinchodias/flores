package model.commission;

import model.JuridicPerson;
import model.Store;
import model.expense.Expense;
import model.money.Pesos;
import model.receipt.Sell;

import org.joda.time.ReadableInterval;

import query.QueryFactory;
import query.criteria.IntervalSearchCriteria;
import query.framework.query.SearchQuery;
import query.framework.results.SearchResults;

public class BasicCommissionsManager implements CommisionsManager {
	
	private final Store store;
	private double commisionAlpha;

	public BasicCommissionsManager(Store store) {
		this.store = store;
		this.commisionAlpha = 0.5;
	}

	public CommissionSummary commissionAt(JuridicPerson vendor, final ReadableInterval lapse) {
		//		Collection<Sell> sells = store.sellsAt(vendor, lapse);
		SearchQuery sellSearchQuery = QueryFactory.instance().sellSearchQuery();
		sellSearchQuery.setCriteria(new IntervalSearchCriteria() {
			
			public ReadableInterval getInterval() {
				return lapse;
			}
		});
		SearchResults sells = sellSearchQuery.results();
		
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

	private Pesos sellTotal(Iterable<Sell> sells) {
		Pesos total = Pesos.newFor(0.0);
		for (Sell sell : sells) {
			total = total.plus(sell.sellTotal());
		}
		return total;
	}

	private Pesos costTotal(Iterable<Sell> sells) {
		Pesos total = Pesos.newFor(0.0);
		for (Sell sell : sells) {
			total = total.plus(sell.costTotal());
		}
		return total;
	}
}
