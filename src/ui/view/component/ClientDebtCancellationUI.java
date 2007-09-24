package ui.view.component;

import ui.controller.initializer.search.SearchDialogInitializer;
import model.JuridicPerson;
import model.money.MoneyAmount;


public interface ClientDebtCancellationUI extends DetailUI {

	MoneyAmount getAmount();

	JuridicPerson getClient();
	
	void setClientSearchInitializer(SearchDialogInitializer initializer);
	
}
