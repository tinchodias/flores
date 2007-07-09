package ui.view.component;

import model.JuridicPerson;
import model.money.Pesos;
import ui.controller.action.Action;
import ui.controller.initializer.search.SearchDialogInitializer;

public interface SellUI extends DetailUI {

	JuridicPerson getClient();
	
	Pesos getCashPay();

	void setClient(JuridicPerson client);
	
	void setCashPay(Pesos value);
	
	SearchUI getItemsPanel();
	
	
	void setClientSearchInitializer(SearchDialogInitializer initializer);
	
	void setAdjustTotalAction(Action action);
	
}