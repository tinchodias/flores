package ui.controller.manager;

import ui.controller.initializer.search.BuysDialogInitializer;

public class BuyManager extends StandardUIModelManager {

	public BuyManager() {
		super(new BuysDialogInitializer(), store().buys());
	}
	
}
