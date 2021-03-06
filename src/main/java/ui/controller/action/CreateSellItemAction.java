package ui.controller.action;

import message.MessageId;
import model.Store;
import model.money.MoneyAmount;
import model.receipt.SellItem;
import persistence.ModelPersistence;
import query.framework.results.SellItemsLazySearchResults;
import ui.view.component.SellItemUI;
import ui.view.component.SellUI;

public class CreateSellItemAction implements Action {

	private final SellItemUI sellItemUI;
	private final SellUI sellUI;

	public CreateSellItemAction(SellItemUI sellItemUI, SellUI sellUI) {
		this.sellItemUI = sellItemUI;
		this.sellUI = sellUI;
	}

	public void execute() {
		SellItemsLazySearchResults results = 
			(SellItemsLazySearchResults) sellUI.getItemsPanel().getResults();

		results.add(sellItem());

		sellUI.getItemsPanel().setResults(results);
		
		sellItemUI.setVisible(false);
	}

	private SellItem sellItem() {
		return new SellItem(sellItemUI.getArticle(), sellItemUI.getCount(), sellItemUI.getValue(), itemCost());
	}

	private MoneyAmount itemCost() {
		//TODO look this
		Store store = ModelPersistence.instance().loadedModel().store();
		return store.stock().cost(sellItemUI.getArticle());
	}

	public MessageId messageId() {
		return MessageId.accept;
	}

}
