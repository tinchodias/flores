package ui.controller.initializer.detail;

import message.MessageId;
import ui.controller.action.Action;
import ui.controller.action.CloseDialogAction;
import ui.controller.action.CompositeAction;
import ui.controller.action.CreateSellItemAction;
import ui.controller.action.ShowSellItemInfoAction;
import ui.controller.action.ShowDialogAction;
import ui.controller.action.ShowPriceAction;
import ui.controller.initializer.DialogInitializer;
import ui.controller.manager.StockManager;
import ui.view.component.DialogUI;
import ui.view.component.SellUI;
import ui.view.swing.component.detail.SellItemDialog;

public class CreateSellItemDialogInitializer implements DialogInitializer {

	private final SellUI sellUI;

	public CreateSellItemDialogInitializer(SellUI sellUI) {
		this.sellUI = sellUI;
	}

	public DialogUI dialog() {
		SellItemDialog dialog = new SellItemDialog();
		
		dialog.setArticleManager(new StockManager());
		dialog.addOnArticleSelectionAction(new ShowSellItemInfoAction(dialog));
		dialog.addOnArticleSelectionAction(new ShowPriceAction(dialog));
		
		Action createSellItemAction = new CreateSellItemAction(dialog, sellUI);
		Action showAction = new ShowDialogAction(this);
		Action action = new CompositeAction(createSellItemAction, showAction, MessageId.acceptAndContinue);
		dialog.setAcceptAction(action);
		
		dialog.setCancelAction(new CloseDialogAction(dialog));
		
		dialog.setCount(1.0);
		
		
		return dialog;
	}

}
