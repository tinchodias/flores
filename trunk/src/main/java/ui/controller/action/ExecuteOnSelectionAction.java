package ui.controller.action;

import message.MessageId;
import ui.UI;
import ui.view.component.SearchUI;

public class ExecuteOnSelectionAction implements Action {

	private final SearchUI searchUI;
	private final Action onSelectionAction;

	public ExecuteOnSelectionAction(SearchUI searchUI, Action onSelectionAction) {
		this.searchUI = searchUI;
		this.onSelectionAction = onSelectionAction;
	}

	public void execute() {
		Object selection = searchUI.getSelection();
		if (selection == null) {
			UI.instance().showInfo(MessageId.noSelection);
		} else {
			onSelectionAction.execute();
		}
	}

	public MessageId messageId() {
		return onSelectionAction.messageId();
	}

}
