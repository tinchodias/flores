package ui.controller.action;

import message.MessageId;
import ui.UI;
import ui.view.component.SearchUI;
import util.ValueHolder;

public class ExecuteOnSelectionAction implements Action {

	private final SearchUI searchUI;
	private final ValueHolder valueHolder;
	private final Action onSelectionAction;
	private final MessageId messageId;

	public ExecuteOnSelectionAction(SearchUI searchUI, ValueHolder valueHolder, Action onSelectionAction, MessageId messageId) {
		this.searchUI = searchUI;
		this.valueHolder = valueHolder;
		this.onSelectionAction = onSelectionAction;
		this.messageId = messageId;
	}

	public void execute() {
		Object selection = searchUI.getSelection();
		if (selection == null) {
			UI.instance().showInfo(MessageId.invalidSelection);
		} else {
			valueHolder.setValue(selection);
			onSelectionAction.execute();
		}
	}

	public MessageId messageId() {
		return messageId;
	}

}
