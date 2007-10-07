package ui.controller.action;

import message.MessageId;
import model.Store;
import model.money.MoneyAmount;
import persistence.ModelPersistence;
import ui.view.component.SellItemUI;

public class ShowSellItemInfoAction implements Action {

	private final SellItemUI sellItemUI;

	public ShowSellItemInfoAction(SellItemUI sellItemUI) {
		this.sellItemUI = sellItemUI;
	}

	public void execute() {
		Store store = ModelPersistence.instance().loadedModel().store();
		
		MoneyAmount cost = store.stock().cost(sellItemUI.getArticle());
		sellItemUI.setCost(cost.toString());
		
		Double count = store.stock().count(sellItemUI.getArticle());
		sellItemUI.setStockCount(count.toString());
	}

	public MessageId messageId() {
		return MessageId.show;
	}

}
