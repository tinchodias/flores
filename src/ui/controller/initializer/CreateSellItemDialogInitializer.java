package ui.controller.initializer;

import ui.controller.action.CloseDialogAction;
import ui.controller.action.CreateSellItemAction;
import ui.controller.action.ShowCostAction;
import ui.view.component.DialogUI;
import ui.view.component.SellUI;
import ui.view.swing.component.SellItemDialog;

public class CreateSellItemDialogInitializer implements DialogInitializer {

	private final SellUI sellUI;

	public CreateSellItemDialogInitializer(SellUI sellUI) {
		this.sellUI = sellUI;
	}

	public DialogUI dialog() {
		SellItemDialog dialog = new SellItemDialog();
		
		dialog.setArticleSearchInitializer(new StockDialogInitializer());
		dialog.setCostAction(new ShowCostAction(dialog));
		
		dialog.setAcceptAction(new CreateSellItemAction(dialog, sellUI));
		dialog.setCancelAction(new CloseDialogAction(dialog));
		
		return dialog;
	}

}
