package ui.controller.initializer.detail;

import ui.controller.manager.ArticleGroupManager;
import ui.controller.populator.ArticlePopulator;
import ui.view.component.DetailUI;
import ui.view.swing.component.detail.ArticleDialog;

public class StockArticleDetailInitializer extends DetailDialogInitializer {
	
	public StockArticleDetailInitializer() {
		super(new ArticlePopulator());
	}
	
	protected DetailUI baseDialog() {
		ArticleDialog dialog = new ArticleDialog();
		dialog.setArticleGroupManager(new ArticleGroupManager());
		return dialog;
	}
	
}
