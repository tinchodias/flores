package ui.controller.initializer.detail;

import message.MessageId;
import ui.controller.action.Action;
import ui.controller.action.CloseDialogAction;
import ui.controller.action.CompositeAction;
import ui.controller.action.CreateSellItemAction;
import ui.controller.action.ShowCostAction;
import ui.controller.action.ShowDialogAction;
import ui.controller.initializer.DialogInitializer;
import ui.controller.initializer.search.StockDialogInitializer;
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
		
		Action createSellItemAction = new CreateSellItemAction(dialog, sellUI);
		Action showAction = new ShowDialogAction(this);
		Action action = new CompositeAction(createSellItemAction, showAction, MessageId.acceptAndCreateOther);
		dialog.setAcceptAction(action);
		
		dialog.setCancelAction(new CloseDialogAction(dialog));
		
		return dialog;
	}

}
