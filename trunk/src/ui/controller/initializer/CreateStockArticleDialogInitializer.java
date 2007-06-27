package ui.controller.initializer;

import ui.controller.action.CloseDialogAction;
import ui.controller.action.CreateArticleAction;
import ui.view.component.DialogUI;
import ui.view.swing.component.ArticleDialog;

public class CreateStockArticleDialogInitializer implements DialogInitializer {
	
	public DialogUI dialog() {
		ArticleDialog dialog = new ArticleDialog();

		dialog.setAcceptAction(new CreateArticleAction(dialog));
		dialog.setCancelAction(new CloseDialogAction(dialog));
		
		dialog.setArticleGroupSearchInitializer(new ArticleGroupsDialogInitializer());
		
		return dialog;
	}

}
