package ui.controller.initializer.detail;

import ui.controller.populator.ExpenseArticlePopulator;
import ui.view.component.DetailUI;
import ui.view.swing.component.detail.ExpenseArticleDialog;

public class ExpenseArticleDetailInitializer extends DetailDialogInitializer {
	
	public ExpenseArticleDetailInitializer() {
		super(new ExpenseArticlePopulator());
	}
	
	protected DetailUI baseDialog() {
		return new ExpenseArticleDialog();
	}
	
}
