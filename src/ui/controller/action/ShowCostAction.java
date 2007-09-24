package ui.controller.action;

import persistence.ModelPersistence;
import message.MessageId;
import model.Store;
import model.money.MoneyAmount;
import ui.view.component.SellItemUI;

public class ShowCostAction implements Action {

	private final SellItemUI sellItemUI;

	public ShowCostAction(SellItemUI sellItemUI) {
		this.sellItemUI = sellItemUI;
	}

	public void execute() {
		Store store = ModelPersistence.instance().loadedModel().store();
		MoneyAmount cost = store.stock().cost(sellItemUI.getArticle());
		sellItemUI.setCost(cost.toString());
	}

	public MessageId messageId() {
		return MessageId.show;
	}

}
