package ui.controller.action;

import message.MessageId;
import ui.controller.populator.DetailPopulator;
import ui.view.component.DetailUI;

public class CreateAction implements Action {

	private final DetailUI dialog;
	private final DetailPopulator populator;

	public CreateAction(DetailUI dialog, DetailPopulator populator) {
		this.dialog = dialog;
		this.populator = populator;
	}

	public void execute() {
		populator.createFrom(dialog);
		
		dialog.setVisible(false);
	}

	public MessageId messageId() {
		return MessageId.accept;
	}

}
