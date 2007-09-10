package ui.view.component;

import model.Vendor;
import model.money.Pesos;

import org.joda.time.ReadableInterval;

public interface CommissionSummaryUI {

	void setCostTotal(Pesos value);

	void setExpensesTotal(Pesos value);

	void setInterval(ReadableInterval interval);

	void setSellTotal(Pesos value);

	void setTotal(Pesos value);

	void setVendor(Vendor vendor);
	
	Pesos getTotal();
	
	ReadableInterval getInterval();
	
}
