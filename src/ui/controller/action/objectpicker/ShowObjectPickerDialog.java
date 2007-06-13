package ui.controller.action.objectpicker;

import message.MessageId;
import ui.controller.action.Action;
import ui.controller.initializer.StandardSearchDialogInitializer;
import ui.view.component.SearchDialogUI;
import ui.view.swing.util.ObjectPicker;

public class ShowObjectPickerDialog implements Action {

	private final StandardSearchDialogInitializer initializer;
	private final ObjectPicker picker;

	public ShowObjectPickerDialog(StandardSearchDialogInitializer initializer, ObjectPicker picker) {
		this.initializer = initializer;
		this.picker = picker;
	}

	public void execute() {
		SearchDialogUI dialogUI = initializer.dialog();
		dialogUI.add(new ObjectPickerSelectAction(dialogUI, picker));
		dialogUI.setVisible(true);
	}

	public MessageId messageId() {
		return MessageId.objectPickerButton;
	}

}
