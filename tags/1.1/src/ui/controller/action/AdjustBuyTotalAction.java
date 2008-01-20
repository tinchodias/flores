package ui.controller.action;

import message.MessageId;
import model.money.MoneyAmount;
import query.framework.results.BuyItemsLazySearchResults;
import ui.view.component.BuyUI;
import ui.view.swing.component.detail.AdjustTotalDialog;

public class AdjustBuyTotalAction implements Action {

	private final BuyUI buyUI;
	private final AdjustTotalDialog adjustDialog;

	public AdjustBuyTotalAction(AdjustTotalDialog adjustDialog, BuyUI buyUI) {
		this.adjustDialog = adjustDialog;
		this.buyUI = buyUI;
	}

	public void execute() {
		MoneyAmount adjustedTotal = adjustDialog.getAdjustedTotal();
		
		BuyItemsLazySearchResults buyItemsResults = 
			(BuyItemsLazySearchResults) buyUI.getItemsPanel().getResults();
		
		buyItemsResults.getBuyItems().adjustTotal(adjustedTotal);
		
		buyUI.getItemsPanel().setResults(buyItemsResults);
		
		adjustDialog.setVisible(false);
	}

	public MessageId messageId() {
		return MessageId.accept;
	}

}
