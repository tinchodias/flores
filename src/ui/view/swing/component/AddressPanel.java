package ui.view.swing.component;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

import message.MessageId;
import model.address.City;
import ui.controller.manager.UIModelManager;
import ui.view.component.AddressUI;
import ui.view.swing.SwingUI;
import ui.view.swing.util.objectpicker3.ObjectPicker3;

public class AddressPanel extends JPanel implements AddressUI {

	private JTextField addressField;
	private ObjectPicker3 cityPicker;

	public AddressPanel() {
		initComponents();
	}

	private void initComponents() {
		addressField = new JTextField();
		cityPicker = new ObjectPicker3();

//		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
//		Border titledBorder = BorderFactory.createTitledBorder("Domicilio Principal");
//		setBorder(titledBorder);
		add(SwingUI.instance().label(addressField, MessageId.address));
		add(SwingUI.instance().label(cityPicker, MessageId.city));
	}

	public String getAddress() {
		return addressField.getText();
	}

	public void setAddress(String address) {
		addressField.setText(address);
	}
	
	public City getCity() {
		return (City) cityPicker.getSelection();
	}

	public void setCity(City city) {
		cityPicker.setSelection(city);
	}
	
	public void setCityManager(UIModelManager manager) {
		cityPicker.setUIModelManager(manager);
	}
}
