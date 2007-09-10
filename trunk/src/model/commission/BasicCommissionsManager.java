package model.commission;

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
	
	private double commisionAlpha;

	public BasicCommissionsManager() {
		this.commisionAlpha = 0.5;
	}

	public CommissionSummary commissionAt(Vendor vendor, final ReadableInterval interval) {
		
		//FIXME it's ignoring the vendor!
		
		IntervalSearchCriteria criteria = new IntervalSearchCriteria() {
			public ReadableInterval getInterval() {
				return interval;
			}
		};

		SearchQuery sellSearchQuery = QueryFactory.instance().sellSearchQuery();
		sellSearchQuery.setCriteria(criteria);
		SearchResults sells = sellSearchQuery.results();

		SearchQuery expensesSearchQuery = QueryFactory.instance().expensesSearchQuery();
		expensesSearchQuery.setCriteria(criteria);
		SearchResults expenses = expensesSearchQuery.results();
		
		Pesos sellTotal = sellTotal(sells);
		Pesos costTotal = costTotal(sells);
		Pesos expensesTotal = expensesTotal(expenses); 
		
		Pesos commission = commission(sellTotal, costTotal, expensesTotal);
		
		return new CommissionSummary(vendor, interval, sellTotal, costTotal, expensesTotal, commission);
	}

	private Pesos commission(Pesos sellTotal, Pesos costTotal, Pesos expensesTotal) {
		return sellTotal.minus(costTotal.plus(expensesTotal)).by(commisionAlpha);
	}

	private Pesos expensesTotal(Iterable<Expense> expenses) {
		Pesos total = Pesos.newFor(0.0);
		for (Expense expense : expenses) {
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
