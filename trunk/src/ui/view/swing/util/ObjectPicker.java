package ui.view.swing.util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTextField;

import ui.controller.action.objectpicker.ShowObjectPickerDialog;
import ui.controller.initializer.StandardSearchDialogInitializer;


public class ObjectPicker extends Container {

	private JTextField textField;
	private JButton button;
	private Object selection;

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

	public void setSearchInitializer(StandardSearchDialogInitializer initializer) {
		button.setAction(new ActionAdapter(new ShowObjectPickerDialog(initializer, this)));
	}

	public void setSelection(Object selection) {
		this.selection = selection;
		textField.setText(selection.toString());
	}

	public Object getSelection() {
		return selection;
	}

}
