package ui.controller.manager;

import ui.controller.initializer.search.SuppliersDialogInitializer;

public class SupplierManager extends StandardUIModelManager {

	public SupplierManager() {
		super(new SuppliersDialogInitializer(), store().suppliers());
	}
	
}
