package ui.controller.action;

import message.MessageId;
import model.JuridicPerson;
import ui.UI;
import ui.controller.initializer.ClientDialogInitializer;
import ui.view.component.SearchUI;

public class ShowClientAction implements Action {

	private final SearchUI searchUI;

	public ShowClientAction(SearchUI searchUI) {
		this.searchUI = searchUI;
	}

	public void execute() {
		JuridicPerson selection = (JuridicPerson) searchUI.selection();
		if (selection == null) {
			UI.instance().showInfo(MessageId.invalidSelection);
		} else {
			new ClientDialogInitializer().dialog(selection).setVisible(true);
		}
	}

	public String getTitle() {
		return "Ver Cliente";
	}

}
