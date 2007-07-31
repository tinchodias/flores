package ui.controller.action;

import java.util.List;

import message.MessageId;
import model.price.SimplePercentagePriceStrategy;
import model.stock.Article;
import persistence.ModelPersistence;
import transaction.Block;
import ui.view.component.ModifyPercentageUI;
import ui.view.component.SearchUI;

public class ModifyPricePercentagesAction implements Action {

	private final SearchUI searchUI;
	private final ModifyPercentageUI dialog;

	public ModifyPricePercentagesAction(ModifyPercentageUI dialog, SearchUI searchUI) {
		this.dialog = dialog;
		this.searchUI = searchUI;
	}

	public void execute() {
		ModelPersistence.instance().transactionManager().execute(new Block() {
			public Object executeBlock() {
				Double percentage = dialog.getPercentage();
				List<Article> selections = searchUI.getSelections();
				SimplePercentagePriceStrategy priceStrategy = ((SimplePercentagePriceStrategy) ModelPersistence
						.instance().loadedModel().store().priceStrategy());

				for (Article article : selections) {
					priceStrategy.setPriceMargin(article, percentage);
				}
				return null;
			}
		});
		dialog.setVisible(false);
	}

	public MessageId messageId() {
		return MessageId.accept;
	}

}
