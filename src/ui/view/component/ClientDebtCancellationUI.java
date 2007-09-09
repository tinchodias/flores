package ui.view.component;

import ui.controller.initializer.search.SearchDialogInitializer;
import model.JuridicPerson;
import model.money.Pesos;


public interface ClientDebtCancellationUI extends DetailUI {

	Pesos getAmount();

	JuridicPerson getClient();
	
	void setClientSearchInitializer(SearchDialogInitializer initializer);
	
}
