package ui.controller.action;

import message.MessageId;
import message.MessageRepository;
import model.Store;
import persistence.ModelPersistence;
import ui.UI;

public class ShowCurrentCashAction implements Action {

	public void execute() {
		Store store = ModelPersistence.instance().loadedModel().store();
		String message = store.cashBook().currentCash().toString();
		String title = MessageRepository.instance().get(messageId());
		UI.instance().showMessage(message, title );
	}

	public MessageId messageId() {
		return MessageId.currentCash;
	}

}
