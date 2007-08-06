package ui.view.swing.util.objectpicker3;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class ObjectPickerMenuAction extends AbstractAction {

	private final ObjectPicker3 picker;
	private final Object item;

	public ObjectPickerMenuAction(Object item, ObjectPicker3 picker) {
		super(item.toString());
		this.item = item;
		this.picker = picker;
	}

	public void actionPerformed(ActionEvent e) {
		picker.setSelection(item);
		picker.setPopupVisible(false);
	}

}
