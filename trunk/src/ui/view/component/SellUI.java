package ui.view.component;

import model.JuridicPerson;
import model.money.Pesos;
import ui.controller.action.Action;
import ui.controller.initializer.SearchDialogInitializer;

public interface SellUI extends DetailUI {

	JuridicPerson getClient();
	
	Pesos getCashPay();
	
	SearchUI getItemsPanel();
	
	void setClientSearchInitializer(SearchDialogInitializer initializer);
	
	void setAdjustTotalAction(Action action);
	
}