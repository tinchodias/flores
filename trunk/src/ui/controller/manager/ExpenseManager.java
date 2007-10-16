package ui.controller.manager;

import ui.controller.initializer.search.ExpensesDialogInitializer;


public class ExpenseManager extends StandardUIModelManager {

	public ExpenseManager() {
		super(new ExpensesDialogInitializer(), store().expenses());
	}
	
}
