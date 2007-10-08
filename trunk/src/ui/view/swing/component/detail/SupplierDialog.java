package ui.view.swing.component.detail;

import javax.swing.JTextField;

import message.MessageId;
import ui.view.component.AddressUI;
import ui.view.component.SupplierUI;
import ui.view.swing.SwingUI;
import ui.view.swing.component.AddressPanel;

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
		
		centerPanel().add(SwingUI.instance().decorated(nameField, MessageId.supplierName));
		centerPanel().add(SwingUI.instance().titledBorderPanel(addressPanel, MessageId.mainAddress));
	}

	public String getSupplierName() {
		return nameField.getText();
	}

	public void setSupplierName(String name) {
		nameField.setText(name);
	}
	
	public AddressUI getAddressUI() {
		return addressPanel;
	}
}
