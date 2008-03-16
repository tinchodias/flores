package ui.controller.action.objectpicker3;

import message.MessageId;
import ui.UI;
import ui.controller.action.Action;
import ui.view.component.SearchDialogUI;
import ui.view.swing.util.objectpicker3.ObjectPicker3;

public class ObjectPickerSelectAction implements Action {

	private final SearchDialogUI dialogUI;
	private final ObjectPicker3 picker;

	public ObjectPickerSelectAction(SearchDialogUI dialogUI, ObjectPicker3 picker) {
		this.dialogUI = dialogUI;
		this.picker = picker;
	}

	public void execute() {
		Object selection = dialogUI.getSearchPanel().getSelection();
		if (selection == null) {
			UI.instance().showInfo(MessageId.invalidSelection);
		} else {
			picker.setSelection(selection);
			dialogUI.setVisible(false);
		}

	}

	public MessageId messageId() {
		return MessageId.select;
	}

}
