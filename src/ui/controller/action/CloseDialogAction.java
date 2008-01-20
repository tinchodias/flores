package ui.controller.action;

import message.MessageId;
import ui.UI;
import ui.view.component.DialogUI;

public class CloseDialogAction implements Action {

	private final DialogUI dialogUI;
	private final boolean confirm;

	public CloseDialogAction(DialogUI dialogUI) {
		this(dialogUI, false);
	}

	public CloseDialogAction(DialogUI dialogUI, boolean confirm) {
		this.dialogUI = dialogUI;
		this.confirm = confirm;
	}
	
	public void execute() {
		if (confirm) {
			if (!UI.instance().showConfirm(MessageId.closeConfirmation)) {
				return;
			}
		}
		dialogUI.setVisible(false);
	}

	public MessageId messageId() {
		return MessageId.close;
	}

}
