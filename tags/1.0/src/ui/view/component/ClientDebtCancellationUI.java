package ui.view.component;

import ui.controller.manager.UIModelManager;
import model.JuridicPerson;
import model.money.MoneyAmount;


public interface ClientDebtCancellationUI extends DetailUI {

	MoneyAmount getAmount();

	JuridicPerson getClient();
	
	void setClientManager(UIModelManager manager);
	
}
