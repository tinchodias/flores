package ui.controller.initializer.detail;

import ui.controller.initializer.search.ArticleGroupsDialogInitializer;
import ui.view.component.DetailUI;
import ui.view.swing.component.detail.ArticleDialog;

public class StockArticleDetailInitializer extends DetailDialogInitializer {
	
	protected DetailUI baseDialog() {
		ArticleDialog dialog = new ArticleDialog();
		
		dialog.setArticleGroupSearchInitializer(new ArticleGroupsDialogInitializer());
		
		return dialog;
	}
	
}
