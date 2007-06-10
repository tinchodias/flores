package ui.view.swing.util.simpleSearcher;

import message.MessageId;
import message.MessageRepository;
import ui.UI;
import ui.controller.action.Action;
import ui.view.component.SearchDialogUI;

public class SelectAction implements Action {

	private final SearchDialogUI dialogUI;
	private final SimpleSearcher simpleSearcher;

	public SelectAction(SearchDialogUI dialogUI, SimpleSearcher simpleSearcher) {
		this.dialogUI = dialogUI;
		this.simpleSearcher = simpleSearcher;
	}

	public void execute() {
		Object selection = dialogUI.getSearchPanel().selection();
		if (selection == null) {
			UI.instance().showInfo(MessageId.invalidSelection);
		} else {
			simpleSearcher.setSelection(selection);
			dialogUI.setVisible(false);
		}

	}

	public String getTitle() {
		return MessageRepository.instance().get(MessageId.select);
	}

}
