package model.commission;

import model.Vendor;
import model.money.Pesos;

import org.joda.time.ReadableInterval;

public class CommissionSummary {

	private final Vendor vendor;
	private final ReadableInterval interval;
	private final Pesos sellTotal;
	private final Pesos costTotal;
	private final Pesos expensesTotal;
	private final Pesos total;
	
	public CommissionSummary(Vendor vendor, ReadableInterval interval, Pesos sellTotal, Pesos costTotal, Pesos expensesTotal, Pesos total) {
		this.vendor = vendor;
		this.interval = interval;
		this.sellTotal = sellTotal;
		this.costTotal = costTotal;
		this.expensesTotal = expensesTotal;
		this.total = total;
	}

	public Pesos getCostTotal() {
		return costTotal;
	}

	public Pesos getExpensesTotal() {
		return expensesTotal;
	}

	public ReadableInterval getInterval() {
		return interval;
	}

	public Pesos getSellTotal() {
		return sellTotal;
	}

	public Pesos getTotal() {
		return total;
	}

	public Vendor getVendor() {
		return vendor;
	}
}
