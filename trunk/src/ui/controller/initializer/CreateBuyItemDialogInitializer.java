package ui.controller.initializer;

import ui.controller.action.CloseDialogAction;
import ui.controller.action.CreateBuyItemAction;
import ui.view.component.BuyUI;
import ui.view.component.DialogUI;
import ui.view.swing.component.BuyItemDialog;

public class CreateBuyItemDialogInitializer implements DialogInitializer {

	private final BuyUI buyUI;

	public CreateBuyItemDialogInitializer(BuyUI buyUI) {
		this.buyUI = buyUI;
	}

	public DialogUI dialog() {
		BuyItemDialog dialog = new BuyItemDialog();
		
		dialog.setArticleSearchInitializer(new StockDialogInitializer());
		
		dialog.setAcceptAction(new CreateBuyItemAction(dialog, buyUI));
		dialog.setCancelAction(new CloseDialogAction(dialog));
		
		return dialog;
	}

}
