package ui.controller.manager;

import message.MessageId;
import ui.controller.initializer.search.ExpensesDialogInitializer;


public class ExpenseManager extends StandardUIModelManager {

	public ExpenseManager() {
		super(new ExpensesDialogInitializer(), store().expenses(), MessageId.expense);
	}
	
}
