package ui.controller.action;

import message.MessageId;
import model.receipt.BuyItem;
import query.framework.results.LazySearchResults;
import ui.view.component.BuyItemUI;
import ui.view.component.BuyUI;

public class CreateBuyItemAction implements Action {

	private final BuyItemUI buyItemUI;
	private final BuyUI buyUI;

	public CreateBuyItemAction(BuyItemUI buyItemUI, BuyUI buyUI) {
		this.buyItemUI = buyItemUI;
		this.buyUI = buyUI;
	}

	public void execute() {
		//TODO re think this Action?
		LazySearchResults results = (LazySearchResults) buyUI.getItemsPanel().getResults();
		
		results.add(new BuyItem(buyItemUI.getArticle(), buyItemUI.getCount(), buyItemUI.getValue()));

		buyUI.getItemsPanel().setResults(results);
		
		buyItemUI.setVisible(false);
	}

	public MessageId messageId() {
		return MessageId.accept;
	}

}
