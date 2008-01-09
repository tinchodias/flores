package ui.view.swing.util.objectpicker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.apache.commons.lang.ObjectUtils;

import ui.controller.action.objectpicker.ShowObjectPickerDialog;
import ui.controller.initializer.search.SearchDialogInitializer;
import ui.view.swing.util.actionadapter.ActionAdapter;


public class ObjectPicker extends Container {

	private JTextField textField;
	private JButton button;
	private Object selection;
	private List<SelectionListener> selectionListeners = new ArrayList();

	public ObjectPicker() {
		setLayout(new BorderLayout());
		
		textField = new JTextField();
		Color background = textField.getBackground();
		textField.setEnabled(false);
		textField.setBackground(background);

		button = new JButton();
		Dimension size = textField.getPreferredSize();
		button.setPreferredSize(new Dimension(size.height, size.height));
		
		add(textField, BorderLayout.CENTER);
		add(button, BorderLayout.EAST);
	}

	public void setSearchInitializer(SearchDialogInitializer initializer) {
		button.setAction(new ActionAdapter(new ShowObjectPickerDialog(initializer, this)));
	}

	public void setSelection(Object selection) {
		this.selection = selection;
		textField.setText(ObjectUtils.toString(selection));
		notifySelection();
	}

	public Object getSelection() {
		return selection;
	}

	private void notifySelection() {
		for (SelectionListener listener: selectionListeners) {
			listener.selected(getSelection());
		}  
	}
	
	public void addSelectionListener(SelectionListener listener) {
		selectionListeners.add(listener);
	}

}
