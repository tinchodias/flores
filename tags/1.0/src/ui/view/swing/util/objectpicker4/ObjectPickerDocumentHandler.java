package ui.view.swing.util.objectpicker4;

import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

import query.framework.criteria.StringCriteria;
import query.framework.query.SearchQuery;

public class ObjectPickerDocumentHandler implements DocumentListener, StringCriteria {

	private final ObjectPicker4 picker;
	private final JTextComponent editor;

	public ObjectPickerDocumentHandler(ObjectPicker4 picker, JTextComponent editor) {
		this.picker = picker;
		this.editor = editor;
	}

	public void changedUpdate(DocumentEvent e) {
//		doSearch();
	}

	public void insertUpdate(DocumentEvent e) {
		doSearch();
	}

	public void removeUpdate(DocumentEvent e) {
		doSearch();
	}

	private void doSearch() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				doSearch2();
			}
		});
	}

	private void doSearch2() {
		SearchQuery query = picker.getQuery();
		query.setCriteria(this);
		picker.setResults(query.results());
	}

	public String getString() {
		return editor.getText();
	}
	
}
