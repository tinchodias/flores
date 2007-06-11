package ui.controller.action;

import message.MessageId;
import ui.controller.initializer.DialogInitializer;

public class ShowDialogAction implements Action {

	private final DialogInitializer initializer;
	private MessageId titleMessageId;

	public ShowDialogAction(DialogInitializer initializer, MessageId titleMessageId) {
		this.initializer = initializer;
		this.titleMessageId = titleMessageId;
	}

	public void execute() {
		initializer.dialog().setVisible(true);
	}

	public MessageId messageId() {
		return titleMessageId;
	}

}
