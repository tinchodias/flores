package ui.controller.action;

import message.MessageId;
import ui.view.component.DialogUI;

public class CloseDialogAction implements Action {

	private final DialogUI dialogUI;

	public CloseDialogAction(DialogUI dialogUI) {
		this.dialogUI = dialogUI;
	}

	public void execute() {
		dialogUI.setVisible(false);
	}

	public MessageId messageId() {
		return MessageId.close;
	}

}
