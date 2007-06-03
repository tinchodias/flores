package ui.controller.action;

import message.MessageId;
import message.MessageRepository;
import model.JuridicPerson;
import ui.UI;
import ui.controller.initializer.ModifyClientDialogInitializer;
import ui.view.component.SearchUI;

public class ShowModifyClientAction implements Action {

	private final SearchUI searchUI;

	public ShowModifyClientAction(SearchUI searchUI) {
		this.searchUI = searchUI;
	}

	public void execute() {
		JuridicPerson selection = (JuridicPerson) searchUI.selection();
		if (selection == null) {
			UI.instance().showInfo(MessageId.invalidSelection);
		} else {
			new ModifyClientDialogInitializer(selection).dialog().setVisible(true);
		}
	}

	public String getTitle() {
		return MessageRepository.instance().get(MessageId.modify);
	}

}
