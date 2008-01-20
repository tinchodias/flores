package ui.view.swing.util.objectpicker3;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import query.framework.criteria.StringCriteria;
import query.framework.query.SearchQuery;

public class ObjectPickerDocumentHandler implements DocumentListener, StringCriteria {

	private final ObjectPicker3 picker;

	public ObjectPickerDocumentHandler(ObjectPicker3 picker) {
		this.picker = picker;
	}

	public void changedUpdate(DocumentEvent e) {
	}

	public void insertUpdate(DocumentEvent e) {
		doSearch();
	}

	public void removeUpdate(DocumentEvent e) {
		doSearch();
	}

	private void doSearch() {
		picker.setDirtyField(true);
		SearchQuery query = picker.getQuery();
		query.setCriteria(this);
		picker.setResults(query.results());
	}

	public String getString() {
		return picker.getString();
	}
	
}
