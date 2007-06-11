package ui.view.swing.util.simpleSearcher;

import message.MessageId;
import ui.controller.action.Action;
import ui.controller.initializer.StandardSearchDialogInitializer;
import ui.view.component.SearchDialogUI;

public class ShowSimpleSearcherDialog implements Action {

	private final StandardSearchDialogInitializer initializer;
	private final SimpleSearcher simpleSearcher;

	public ShowSimpleSearcherDialog(StandardSearchDialogInitializer initializer, SimpleSearcher simpleSearcher) {
		this.initializer = initializer;
		this.simpleSearcher = simpleSearcher;
	}

	public void execute() {
		SearchDialogUI dialogUI = initializer.dialog();
		dialogUI.add(new SelectAction(dialogUI, simpleSearcher));
		dialogUI.setVisible(true);
	}

	public MessageId messageId() {
		return MessageId.simpleSearch;
	}

}
