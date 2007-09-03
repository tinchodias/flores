package ui.controller.initializer.detail;

import ui.controller.initializer.search.ExpensesArticlesDialogInitializer;
import ui.controller.populator.ExpensePopulator;
import ui.view.component.DetailUI;
import ui.view.swing.component.detail.ExpenseDialog;

public class ExpenseDetailInitializer extends DetailDialogInitializer {
	
	public ExpenseDetailInitializer() {
		super(new ExpensePopulator());
	}
	
	protected DetailUI baseDialog() {
		ExpenseDialog dialog = new ExpenseDialog();
		dialog.setExpenseArticleSearchInitializer(new ExpensesArticlesDialogInitializer());
		
		return dialog;
	}
	
}
