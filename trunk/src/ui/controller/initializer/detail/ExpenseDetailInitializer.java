package ui.controller.initializer.detail;

import ui.controller.initializer.search.ExpensesArticlesDialogInitializer;
import ui.view.component.DetailUI;
import ui.view.swing.component.detail.ExpenseDialog;

public class ExpenseDetailInitializer extends DetailDialogInitializer {
	
	protected DetailUI baseDialog() {
		ExpenseDialog dialog = new ExpenseDialog();
		dialog.setExpenseArticleSearchInitializer(new ExpensesArticlesDialogInitializer());
		
		return dialog;
	}
	
}
