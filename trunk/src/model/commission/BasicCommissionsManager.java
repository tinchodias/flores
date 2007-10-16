package model.commission;

import model.Vendor;
import model.debts.LostDebtDeclaration;
import model.expense.Expense;
import model.money.MoneyAmount;
import model.receipt.Sell;
import model.stock.StockDropOut;

import org.joda.time.ReadableInterval;

import query.QueryFactory;
import query.criteria.IntervalSearchCriteria;
import query.framework.query.SearchQuery;
import query.framework.results.SearchResults;

public class BasicCommissionsManager implements CommisionsManager {
	
	private static final double DEFAULT_COMMISSION_MULTIPLIER = 0.5;
	private double commisionMultiplier = DEFAULT_COMMISSION_MULTIPLIER;


	public double getCommisionMultiplier() {
		return commisionMultiplier;
	}

	public void setCommisionMultiplier(double commisionMultiplier) {
		this.commisionMultiplier = commisionMultiplier;
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
		MoneyAmount sellTotal = sellTotal(sells);
		MoneyAmount costTotal = costTotal(sells);

		SearchQuery expenseSearchQuery = QueryFactory.instance().expensesSearchQuery();
		expenseSearchQuery.setCriteria(criteria);
		MoneyAmount expensesTotal = expenseTotal(expenseSearchQuery.results()); 

		SearchQuery lostDebtDeclarationSearchQuery = QueryFactory.instance().lostDebtDeclarationsSearchQuery();
		lostDebtDeclarationSearchQuery.setCriteria(criteria);
		MoneyAmount lostDebtDeclarationsTotal = lostDebtDeclarationTotal(lostDebtDeclarationSearchQuery.results()); 

		SearchQuery stockDropOutSearchQuery = QueryFactory.instance().stockDropOutSearchQuery();
		stockDropOutSearchQuery.setCriteria(criteria);
		MoneyAmount stockDropOutTotal = stockDropOutTotal(stockDropOutSearchQuery.results()); 

		MoneyAmount otherLosses = lostDebtDeclarationsTotal.plus(stockDropOutTotal);
		
		MoneyAmount commissionTotal = commission(sellTotal, costTotal.plus(expensesTotal).plus(otherLosses));
		
		return new CommissionSummary(vendor, interval, sellTotal, costTotal, expensesTotal, otherLosses, commissionTotal);
	}

	private MoneyAmount stockDropOutTotal(Iterable<StockDropOut> dropOuts) {
		MoneyAmount total = MoneyAmount.newFor(0.0);
		for (StockDropOut dropOut : dropOuts) {
			total = total.plus(dropOut.getUnitCost().by(dropOut.getCount()));
		}
		return total;
	}
	
	private MoneyAmount lostDebtDeclarationTotal(Iterable<LostDebtDeclaration> declarations) {
		MoneyAmount total = MoneyAmount.newFor(0.0);
		for (LostDebtDeclaration declaration : declarations) {
			total = total.plus(declaration.getAmount());
		}
		return total;
	}

	private MoneyAmount expenseTotal(Iterable<Expense> expenses) {
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

	private MoneyAmount commission(MoneyAmount gains, MoneyAmount losses) {
		return gains.minus(losses).by(commisionMultiplier);
	}

}
