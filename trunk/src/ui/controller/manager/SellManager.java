package ui.controller.manager;

import ui.controller.initializer.search.SellsDialogInitializer;

public class SellManager extends StandardUIModelManager {

	public SellManager() {
		super(new SellsDialogInitializer(), store().sells());
	}
	
}
