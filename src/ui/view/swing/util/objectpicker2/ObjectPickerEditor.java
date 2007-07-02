package ui.view.swing.util.objectpicker2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboBoxEditor;

import query.framework.criteria.StringCriteria;
import query.framework.results.NullSearchResults;
import query.framework.results.SearchResults;

public class ObjectPickerEditor extends BasicComboBoxEditor implements KeyListener, StringCriteria {
	
	private JTextField dummyEditor;
	private final ObjectPicker2 picker;

	public ObjectPickerEditor(ObjectPicker2 picker) {
		this.picker = picker;
		dummyEditor = createEditorComponent();
		editor.addKeyListener(this);
	}

	public void keyPressed(KeyEvent e) {
		//TODO
		if (e.isControlDown()) {
			keyTyped(e);
		}
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
		applyToDummyEditor(e);
		
//		if (hasDummyEditorChanges()) {
		if (getString().length() == 0) {
			picker.setResults(NullSearchResults.instance());
		} else {
			System.out.println("Searching for: [" + getString() + "]");
			picker.getQuery().setCriteria(this);
			SearchResults results = picker.getQuery().results();
			
			if (results.getRowCount() > 0) {
				picker.setResults(results);
				editor.setCaretPosition(dummyEditor.getCaretPosition());
			}
		}
	}

//	private boolean hasDummyEditorChanges() {
//		return !editor.getText().equals(dummyEditor.getText()) || 
//			(editor.getCaretPosition() != dummyEditor.getCaretPosition());
//	}

	private void applyToDummyEditor(KeyEvent e) {
		dummyEditor.setText(editor.getText());
		dummyEditor.setCaretPosition(editor.getCaretPosition());
		dummyEditor.setSelectionStart(editor.getSelectionStart());
		dummyEditor.setSelectionEnd(editor.getSelectionEnd());
		dummyEditor.dispatchEvent(e);
	}

	public String getString() {
		int endIndex = dummyEditor.getCaretPosition();
		return dummyEditor.getText().substring(0, endIndex );
	}

}
