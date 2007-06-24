package ui.controller.action;

import query.framework.results.BuyItemsLazySearchResults;
import message.MessageId;
import model.money.Pesos;
import ui.view.swing.component.AdjustBuyTotalDialog;
import ui.view.swing.component.BuyDialog;

public class AdjustBuyTotalAction implements Action {

	private final BuyDialog buyDialog;
	private final AdjustBuyTotalDialog adjustDialog;

	public AdjustBuyTotalAction(AdjustBuyTotalDialog adjustDialog, BuyDialog buyDialog) {
		this.adjustDialog = adjustDialog;
		this.buyDialog = buyDialog;
	}

	public void execute() {
		Pesos adjustedTotal = adjustDialog.getAdjustedTotal();
		
		BuyItemsLazySearchResults buyItemsResults = 
			(BuyItemsLazySearchResults) buyDialog.getItemsPanel().getResults();
		
		buyItemsResults.getBuyItems().adjustTotal(adjustedTotal);
		
		buyDialog.getItemsPanel().setResults(buyItemsResults);
		
		adjustDialog.setVisible(false);
	}

	public MessageId messageId() {
		return MessageId.accept;
	}

}
