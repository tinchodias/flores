package ui.view.component;

import model.JuridicPerson;
import model.money.MoneyAmount;
import ui.controller.action.Action;
import ui.controller.initializer.search.SearchDialogInitializer;

public interface SellUI extends DetailUI {

	JuridicPerson getClient();
	
	MoneyAmount getCashPay();

	void setClient(JuridicPerson client);
	
	void setCashPay(MoneyAmount value);
	
	SearchUI getItemsPanel();
	
	
	void setClientSearchInitializer(SearchDialogInitializer initializer);
	
	void setAdjustTotalAction(Action action);
	
}