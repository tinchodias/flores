package ui.view.swing.component;

import javax.swing.JTextField;

import message.MessageId;
import ui.view.component.AddressUI;
import ui.view.component.SupplierUI;
import ui.view.swing.SwingUI;

public class SupplierDialog extends StandardDetailDialog implements SupplierUI {

	private JTextField nameField;
	private AddressPanel addressPanel;

	public SupplierDialog() {
		super(MessageId.supplierDialogTitle);
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		nameField = new JTextField();
		addressPanel = new AddressPanel();
		
		centerPanel().add(SwingUI.instance().label(nameField, MessageId.supplierName));
		centerPanel().add(addressPanel);
	}

	public String getSupplierName() {
		return nameField.getText();
	}

	public AddressUI getAddressUI() {
		return addressPanel;
	}
}
