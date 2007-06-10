package model.commission;

import model.JuridicPerson;
import model.money.Pesos;

import org.joda.time.ReadableInterval;

public class CommissionSummary {

	private final JuridicPerson vendor;
	private final ReadableInterval lapse;
	private final Pesos sellTotal;
	private final Pesos costTotal;
	private final Pesos expensesTotal;
	private final Pesos total;
	
	public CommissionSummary(JuridicPerson vendor, ReadableInterval lapse, Pesos sellTotal, Pesos costTotal, Pesos expensesTotal, Pesos total) {
		this.vendor = vendor;
		this.lapse = lapse;
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

	public ReadableInterval getLapse() {
		return lapse;
	}

	public Pesos getSellTotal() {
		return sellTotal;
	}

	public Pesos getTotal() {
		return total;
	}

	public JuridicPerson getVendor() {
		return vendor;
	}
}
