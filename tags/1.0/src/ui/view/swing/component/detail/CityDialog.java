package ui.view.swing.component.detail;

import javax.swing.JTextField;

import message.MessageId;
import model.address.Province;
import ui.controller.manager.UIModelManager;
import ui.view.component.CityUI;
import ui.view.swing.SwingUI;
import ui.view.swing.util.objectpicker3.ObjectPicker3;

public class CityDialog extends StandardDetailDialog implements CityUI {

	private JTextField nameField;
	private ObjectPicker3 provincePicker;

	public CityDialog() {
		super(MessageId.city);
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		nameField = new JTextField();
		provincePicker = new ObjectPicker3();
		
		centerPanel().add(SwingUI.instance().decorated(nameField, MessageId.city));
		centerPanel().add(SwingUI.instance().decorated(provincePicker, MessageId.province));
	}

	public String getCityName() {
		return nameField.getText();
	}

	public void setCityName(String name) {
		nameField.setText(name);
	}
	
	public Province getProvince() {
		return (Province) provincePicker.getSelection();
	}

	public void setProvince(Province province) {
		provincePicker.setSelection(province);
	}
	
	public void setProvinceManager(UIModelManager manager) {
		provincePicker.setUIModelManager(manager);
	}
	
}
