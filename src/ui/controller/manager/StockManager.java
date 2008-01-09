package ui.controller.manager;

import ui.controller.initializer.search.StockDialogInitializer;

public class StockManager extends StandardUIModelManager {

	public StockManager() {
		super(new StockDialogInitializer(), store().stockArticles());
	}
	
}
