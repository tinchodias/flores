package ui.controller.initializer.detail;

import ui.controller.manager.ExpenseArticleManager;
import ui.controller.populator.ExpensePopulator;
import ui.view.component.DetailUI;
import ui.view.swing.component.detail.ExpenseDialog;

public class ExpenseDetailInitializer extends DetailDialogInitializer {
	
	public ExpenseDetailInitializer() {
		super(new ExpensePopulator());
	}
	
	protected DetailUI baseDialog() {
		ExpenseDialog dialog = new ExpenseDialog();
		dialog.setExpenseArticleManager(new ExpenseArticleManager());
		
		return dialog;
	}
	
}
