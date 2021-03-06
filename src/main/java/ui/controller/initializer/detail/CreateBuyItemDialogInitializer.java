package ui.controller.initializer.detail;

import message.MessageId;
import ui.controller.action.Action;
import ui.controller.action.CloseDialogAction;
import ui.controller.action.CompositeAction;
import ui.controller.action.CreateBuyItemAction;
import ui.controller.action.ShowDialogAction;
import ui.controller.initializer.DialogInitializer;
import ui.controller.manager.StockManager;
import ui.view.component.BuyUI;
import ui.view.component.DialogUI;
import ui.view.swing.component.detail.BuyItemDialog;

public class CreateBuyItemDialogInitializer implements DialogInitializer {

	private final BuyUI buyUI;

	public CreateBuyItemDialogInitializer(BuyUI buyUI) {
		this.buyUI = buyUI;
	}

	public DialogUI dialog() {
		BuyItemDialog dialog = new BuyItemDialog();
		
		dialog.setArticleManager(new StockManager());

		Action createBuyItemAction = new CreateBuyItemAction(dialog, buyUI);
		Action showAction = new ShowDialogAction(this);
		Action action = new CompositeAction(createBuyItemAction, showAction, MessageId.acceptAndContinue);
		dialog.setAcceptAction(action);
		
		dialog.setCancelAction(new CloseDialogAction(dialog));
		
		return dialog;
	}

}
