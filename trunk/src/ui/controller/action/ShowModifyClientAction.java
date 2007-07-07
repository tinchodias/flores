package ui.controller.action;

import message.MessageId;
import model.JuridicPerson;
import ui.UI;
import ui.controller.initializer.detail.ModifyClientDialogInitializer;
import ui.view.component.SearchUI;

public class ShowModifyClientAction implements Action {

	private final SearchUI searchUI;

	public ShowModifyClientAction(SearchUI searchUI) {
		this.searchUI = searchUI;
	}

	public void execute() {
		JuridicPerson selection = (JuridicPerson) searchUI.getSelection();
		if (selection == null) {
			UI.instance().showInfo(MessageId.invalidSelection);
		} else {
			new ModifyClientDialogInitializer(selection).dialog().setVisible(true);
		}
	}

	public MessageId messageId() {
		return MessageId.modify;
	}

}
