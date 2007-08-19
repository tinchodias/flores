package ui.controller.initializer.detail;

import ui.view.component.DetailUI;
import ui.view.swing.component.detail.ArticleGroupDialog;

public class ArticleGroupDetailInitializer extends DetailDialogInitializer {

	protected DetailUI baseDialog() {
		return new ArticleGroupDialog();
	}

}
