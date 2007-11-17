package ui.controller.action.objectpicker;

import message.MessageId;
import ui.controller.action.Action;
import ui.controller.initializer.search.SearchDialogInitializer;
import ui.view.component.SearchDialogUI;
import ui.view.swing.util.objectpicker.ObjectPicker;

public class ShowObjectPickerDialog implements Action {

	private final SearchDialogInitializer initializer;
	private final ObjectPicker picker;

	public ShowObjectPickerDialog(SearchDialogInitializer initializer, ObjectPicker picker) {
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
