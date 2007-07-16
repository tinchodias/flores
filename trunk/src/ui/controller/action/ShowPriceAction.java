package ui.controller.action;

import persistence.ModelPersistence;
import message.MessageId;
import model.Store;
import model.money.Pesos;
import model.stock.Article;
import ui.view.component.SellItemUI;

public class ShowPriceAction implements Action {

	private final SellItemUI sellItemUI;

	public ShowPriceAction(SellItemUI sellItemUI) {
		this.sellItemUI = sellItemUI;
	}

	public void execute() {
		Article article = sellItemUI.getArticle();
		Store store = ModelPersistence.instance().loadedModel().store();
		Pesos price = store.priceStrategy().priceFor(article);
		
		sellItemUI.setValue(price.value());
	}

	public MessageId messageId() {
		return MessageId.show;
	}

}
