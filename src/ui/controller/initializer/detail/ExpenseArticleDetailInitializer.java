package ui.controller.initializer.detail;

import ui.view.component.DetailUI;
import ui.view.swing.component.ExpenseArticleDialog;

public class ExpenseArticleDetailInitializer extends DetailDialogInitializer {
	
	protected DetailUI baseDialog() {
		return new ExpenseArticleDialog();
	}
	
}
