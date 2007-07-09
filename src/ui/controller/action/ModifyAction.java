package ui.controller.action;

import message.MessageId;
import ui.controller.populator.DetailPopulator;
import ui.view.component.DetailUI;

public class ModifyAction implements Action {

	private final DetailUI dialog;
	private final DetailPopulator populator;

	public ModifyAction(DetailUI dialog, DetailPopulator populator) {
		this.dialog = dialog;
		this.populator = populator;
	}

	public void execute() {
		populator.modifyFrom(dialog);
		
		dialog.setVisible(false);
	}

	public MessageId messageId() {
		return MessageId.accept;
	}

}
