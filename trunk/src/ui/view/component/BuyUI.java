package ui.view.component;

import model.JuridicPerson;
import model.money.Pesos;
import ui.controller.action.Action;
import ui.controller.initializer.search.SearchDialogInitializer;

public interface BuyUI extends DetailUI {

	JuridicPerson getSupplier();
	
	Pesos getCashPay();

	void setSupplier(JuridicPerson supplier);
	
	void setCashPay(Pesos pay);
	
	SearchUI getItemsPanel();

	
	void setSupplierSearchInitializer(SearchDialogInitializer initializer);
	
	void setAdjustTotalAction(Action action);
	
}