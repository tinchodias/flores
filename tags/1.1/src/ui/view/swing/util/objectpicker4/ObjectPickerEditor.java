package ui.view.swing.util.objectpicker4;

import javax.swing.plaf.basic.BasicComboBoxEditor;

public class ObjectPickerEditor extends BasicComboBoxEditor {
	
	public ObjectPickerEditor(ObjectPicker4 picker) {
		editor.getDocument().addDocumentListener(new ObjectPickerDocumentHandler(picker, editor));
	}

}
