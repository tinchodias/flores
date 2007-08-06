package ui.view.swing.util.objectpicker4;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import query.framework.query.SearchQuery;
import query.framework.results.SearchResults;


public class ObjectPicker4 extends Container {

	private JComboBox combo;
	private JButton button;
	private SearchQuery query;

	public ObjectPicker4() {
		setLayout(new BorderLayout());
		
		combo = new JComboBox();
		combo.setEditable(true);
		combo.setEditor(new ObjectPickerEditor(this));

		button = new JButton();
		Dimension size = combo.getPreferredSize();
		button.setPreferredSize(new Dimension(size.height, size.height));
		
		add(combo, BorderLayout.CENTER);
//		add(button, BorderLayout.EAST);
	}

	public void setQuery(SearchQuery query) {
		this.query = query;
	}

	public SearchQuery getQuery() {
		return query;
	}
	
	public void setSelection(Object item) {
		combo.setSelectedItem(item);
	}

	public Object getSelection() {
		return combo.getSelectedItem();
	}

	public void addItemListener(ItemListener listener) {
		combo.addItemListener(listener);
	}

	public void removeItemListener(ItemListener listener) {
		combo.removeItemListener(listener);
	}
	
	public void setResults(SearchResults results) {
		//TODO optimize!
		DefaultComboBoxModel model = (DefaultComboBoxModel) combo.getModel();
		model.removeAllElements();
		for (int i = 0; i < results.getRowCount(); i++) {
			model.addElement(results.get(i));
		}
		combo.setPopupVisible(results.getRowCount() > 0);
	}

}
