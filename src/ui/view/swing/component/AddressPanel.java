package ui.view.swing.component;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

import message.MessageId;
import model.address.City;
import ui.controller.initializer.search.SearchDialogInitializer;
import ui.view.component.AddressUI;
import ui.view.swing.SwingUI;
import ui.view.swing.util.objectpicker.ObjectPicker;

public class AddressPanel extends JPanel implements AddressUI {

	private JTextField addressField;
	private ObjectPicker cityPicker;

	public AddressPanel() {
		initComponents();
	}

	private void initComponents() {
		addressField = new JTextField();
		cityPicker = new ObjectPicker();

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

	public City getCity() {
		return (City) cityPicker.getSelection();
	}

	public void setCitySearchInitializer(SearchDialogInitializer initializer) {
		cityPicker.setSearchInitializer(initializer);
	}
}