package ui.view.component;

import model.JuridicPerson;
import model.money.MoneyAmount;
import ui.controller.action.Action;
import ui.controller.initializer.search.SearchDialogInitializer;

public interface BuyUI extends DetailUI {

	JuridicPerson getSupplier();
	
	MoneyAmount getCashPay();

	void setSupplier(JuridicPerson supplier);
	
	void setCashPay(MoneyAmount pay);
	
	SearchUI getItemsPanel();

	
	void setSupplierSearchInitializer(SearchDialogInitializer initializer);
	
	void setAdjustTotalAction(Action action);
	
}