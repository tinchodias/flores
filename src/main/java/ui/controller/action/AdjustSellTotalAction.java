package ui.controller.action;

import message.MessageId;
import model.money.MoneyAmount;
import query.framework.results.SellItemsLazySearchResults;
import ui.view.component.AdjustTotalUI;
import ui.view.component.SellUI;

public class AdjustSellTotalAction implements Action {

	private final AdjustTotalUI adjustTotalUI;
	private final SellUI sellUI;

	public AdjustSellTotalAction(AdjustTotalUI adjustDialog, SellUI sellUI) {
		this.adjustTotalUI = adjustDialog;
		this.sellUI = sellUI;
	}

	public void execute() {
		MoneyAmount adjustedTotal = adjustTotalUI.getAdjustedTotal();
		
		SellItemsLazySearchResults sellItemsResults = 
			(SellItemsLazySearchResults) sellUI.getItemsPanel().getResults();
		
		sellItemsResults.getSellItems().adjustTotal(adjustedTotal);
		
		sellUI.getItemsPanel().setResults(sellItemsResults);
		
		adjustTotalUI.setVisible(false);
	}

	public MessageId messageId() {
		return MessageId.accept;
	}

}
