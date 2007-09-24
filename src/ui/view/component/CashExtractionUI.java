package ui.view.component;

import model.money.MoneyAmount;


public interface CashExtractionUI extends DetailUI {

	MoneyAmount getAmount();

	String getNote();
	
	void setAmount(MoneyAmount amount);

	void setNote(String note);
	
}
