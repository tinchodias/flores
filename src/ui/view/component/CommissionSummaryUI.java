package ui.view.component;

import model.Vendor;
import model.money.MoneyAmount;

import org.joda.time.ReadableInterval;

public interface CommissionSummaryUI {

	void setCostTotal(MoneyAmount value);

	void setExpensesTotal(MoneyAmount value);

	void setInterval(ReadableInterval interval);

	void setSellTotal(MoneyAmount value);

	void setTotal(MoneyAmount value);

	void setVendor(Vendor vendor);
	
	MoneyAmount getTotal();
	
	ReadableInterval getInterval();
	
}
