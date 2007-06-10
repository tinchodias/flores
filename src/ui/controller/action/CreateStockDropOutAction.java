package ui.controller.action;

import message.MessageId;
import message.MessageRepository;
import model.stock.StockDropOut;

import org.joda.time.DateTime;

import persistence.ModelPersistence;

import ui.view.component.StockDropOutUI;

public class CreateStockDropOutAction implements Action {

	private final StockDropOutUI detail;

	public CreateStockDropOutAction(StockDropOutUI detail) {
		this.detail = detail;
	}

	public void execute() {
		StockDropOut dropOut = dropOut();
		ModelPersistence.instance().loadedModel().store().stock().add(dropOut);
		
		detail.setVisible(false);
	}

	private StockDropOut dropOut() {
		return new StockDropOut(detail.getArticle(), detail.getCount(), new DateTime());
	}

	public String getTitle() {
		return MessageRepository.instance().get(MessageId.create);
	}

}
