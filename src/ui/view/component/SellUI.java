package ui.view.component;

import model.JuridicPerson;
import model.money.MoneyAmount;
import ui.controller.action.Action;
import ui.controller.manager.UIModelManager;

public interface SellUI extends DetailUI {

	JuridicPerson getClient();
	
	MoneyAmount getCashPay();

	void setClient(JuridicPerson client);
	
	void setCashPay(MoneyAmount value);
	
	SearchUI getItemsPanel();
	
	
	void setClientManager(UIModelManager manager);
	
	void setAdjustTotalAction(Action action);
	
}