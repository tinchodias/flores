package model.commission;

import model.Vendor;
import model.expense.Expense;
import model.money.MoneyAmount;
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
		
		MoneyAmount sellTotal = sellTotal(sells);
		MoneyAmount costTotal = costTotal(sells);
		MoneyAmount expensesTotal = expensesTotal(expenses); 
		
		MoneyAmount commission = commission(sellTotal, costTotal, expensesTotal);
		
		return new CommissionSummary(vendor, interval, sellTotal, costTotal, expensesTotal, commission);
	}

	private MoneyAmount commission(MoneyAmount sellTotal, MoneyAmount costTotal, MoneyAmount expensesTotal) {
		return sellTotal.minus(costTotal.plus(expensesTotal)).by(commisionAlpha);
	}

	private MoneyAmount expensesTotal(Iterable<Expense> expenses) {
		MoneyAmount total = MoneyAmount.newFor(0.0);
		for (Expense expense : expenses) {
			total = total.plus(expense.getCost());
		}
		return total;
	}

	private MoneyAmount sellTotal(Iterable<Sell> sells) {
		MoneyAmount total = MoneyAmount.newFor(0.0);
		for (Sell sell : sells) {
			total = total.plus(sell.sellTotal());
		}
		return total;
	}

	private MoneyAmount costTotal(Iterable<Sell> sells) {
		MoneyAmount total = MoneyAmount.newFor(0.0);
		for (Sell sell : sells) {
			total = total.plus(sell.costTotal());
		}
		return total;
	}
}
