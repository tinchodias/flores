package model.commission;

import model.Store;
import model.Vendor;
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

	public CommissionSummary commissionAt(Vendor vendor, final ReadableInterval interval) {
		
		//FIXME it's ignoring the vendor!
		
		SearchQuery sellSearchQuery = QueryFactory.instance().sellSearchQuery();
		sellSearchQuery.setCriteria(new IntervalSearchCriteria() {
			
			public ReadableInterval getInterval() {
				return interval;
			}
		});
		SearchResults sells = sellSearchQuery.results();
		
		Pesos sellTotal = sellTotal(sells);
		Pesos costTotal = costTotal(sells);
		Pesos expensesTotal = expensesTotal(); 
		
		Pesos commission = commission(sellTotal, costTotal, expensesTotal);
		
		return new CommissionSummary(vendor, interval, sellTotal, costTotal, expensesTotal, commission);
	}

	private Pesos commission(Pesos sellTotal, Pesos costTotal, Pesos expensesTotal) {
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
