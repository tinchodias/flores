package ui.view.component;

import model.JuridicPerson;
import model.money.Pesos;
import ui.controller.initializer.SearchDialogInitializer;

public interface BuyUI extends DetailUI {

	JuridicPerson getSupplier();
	
	Pesos getCashPay();
	
	SearchUI getItemsPanel();
	
	void setSupplierSearchInitializer(SearchDialogInitializer initializer);
	
}