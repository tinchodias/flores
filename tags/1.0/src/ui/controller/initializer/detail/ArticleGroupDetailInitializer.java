package ui.controller.initializer.detail;

import ui.controller.populator.ArticleGroupPopulator;
import ui.view.component.DetailUI;
import ui.view.swing.component.detail.ArticleGroupDialog;

public class ArticleGroupDetailInitializer extends DetailDialogInitializer {

	public ArticleGroupDetailInitializer() {
		super(new ArticleGroupPopulator());
	}
	
	protected DetailUI baseDialog() {
		return new ArticleGroupDialog();
	}

}
