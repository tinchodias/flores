package ui.view.component;

import model.JuridicPerson;
import model.money.MoneyAmount;
import ui.controller.action.Action;
import ui.controller.manager.UIModelManager;

public interface BuyUI extends DetailUI {

	JuridicPerson getSupplier();
	
	MoneyAmount getCashPay();

	void setSupplier(JuridicPerson supplier);
	
	void setCashPay(MoneyAmount pay);
	
	SearchUI getItemsPanel();

	
	void setSupplierManager(UIModelManager manager);
	
	void setAdjustTotalAction(Action action);
	
}