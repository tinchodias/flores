package ui.controller.action;

import message.MessageId;
import ui.UI;
import ui.view.component.SearchUI;

public class ExecuteOnSelectionAction implements Action {

	private final SearchUI searchUI;
	private final Action onSelectionAction;
	private final MessageId messageId;

	public ExecuteOnSelectionAction(SearchUI searchUI, Action onSelectionAction, MessageId messageId) {
		this.searchUI = searchUI;
		this.onSelectionAction = onSelectionAction;
		this.messageId = messageId;
	}

	public void execute() {
		Object selection = searchUI.getSelection();
		if (selection == null) {
			UI.instance().showInfo(MessageId.invalidSelection);
		} else {
			onSelectionAction.execute();
		}
	}

	public MessageId messageId() {
		return messageId;
	}

}
