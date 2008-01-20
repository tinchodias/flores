package ui.controller.action.objectpicker3;

import message.MessageId;
import ui.controller.action.Action;
import ui.controller.initializer.search.SearchDialogInitializer;
import ui.view.component.SearchDialogUI;
import ui.view.swing.util.objectpicker3.ObjectPicker3;

public class ShowObjectPickerDialog implements Action {

	private final SearchDialogInitializer initializer;
	private final ObjectPicker3 picker;

	public ShowObjectPickerDialog(SearchDialogInitializer initializer, ObjectPicker3 picker) {
		this.initializer = initializer;
		this.picker = picker;
	}

	public void execute() {
		SearchDialogUI dialogUI = initializer.dialog();
		ObjectPickerSelectAction action = new ObjectPickerSelectAction(dialogUI, picker);
		dialogUI.getSearchPanel().add(action);
		dialogUI.getSearchPanel().setDefaultAction(action);
		dialogUI.setVisible(true);
	}

	public MessageId messageId() {
		return MessageId.objectPickerButton;
	}

}
