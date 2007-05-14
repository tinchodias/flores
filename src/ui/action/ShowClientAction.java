package ui.action;

import message.MessageId;
import model.JuridicPerson;
import ui.UI;
import ui.component.SearchUI;
import ui.swing.initializer.ClientDialogInitializer;

public class ShowClientAction implements Action {

	private final SearchUI searchUI;

	public ShowClientAction(SearchUI searchUI) {
		this.searchUI = searchUI;
	}

	public void execute() {
		JuridicPerson selection = (JuridicPerson) searchUI.selection();
		if (selection == null) {
			UI.instance().showError(MessageId.invalidSelection);
		} else {
			new ClientDialogInitializer().dialog(selection).setVisible(true);
		}
	}

	public String getTitle() {
		return "Ver Cliente";
	}

}
