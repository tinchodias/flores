package ui.view.component;

import model.money.Pesos;


public interface CashExtractionUI extends DetailUI {

	Pesos getAmount();

	String getNote();
	
}
