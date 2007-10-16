package ui.controller.manager;

import ui.controller.initializer.search.StockDropOutsDialogInitializer;

public class StockDropOutManager extends StandardUIModelManager {

	public StockDropOutManager() {
		super(new StockDropOutsDialogInitializer(), store().stock().dropOuts());
	}
	
}
