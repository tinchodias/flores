package model.commission;

import model.Vendor;
import model.money.MoneyAmount;

import org.joda.time.ReadableInterval;

public class CommissionSummary {

	private final Vendor vendor;
	private final ReadableInterval interval;
	private final MoneyAmount sellTotal;
	private final MoneyAmount costTotal;
	private final MoneyAmount expensesTotal;
	private final MoneyAmount total;
	private final MoneyAmount otherLosses;
	
	public CommissionSummary(Vendor vendor, ReadableInterval interval, MoneyAmount sellTotal, MoneyAmount costTotal, MoneyAmount expensesTotal, MoneyAmount otherLosses, MoneyAmount total) {
		this.vendor = vendor;
		this.interval = interval;
		this.sellTotal = sellTotal;
		this.costTotal = costTotal;
		this.expensesTotal = expensesTotal;
		this.otherLosses = otherLosses;
		this.total = total;
	}

	public MoneyAmount getCostTotal() {
		return costTotal;
	}

	public MoneyAmount getExpensesTotal() {
		return expensesTotal;
	}

	public ReadableInterval getInterval() {
		return interval;
	}

	public MoneyAmount getSellTotal() {
		return sellTotal;
	}

	public MoneyAmount getTotal() {
		return total;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public MoneyAmount getOtherLossesTotal() {
		return otherLosses;
	}
}
