package ui.view.swing.component;

import javax.swing.JTextField;

import message.MessageId;
import ui.view.component.AddressUI;
import ui.view.component.ClientUI;
import ui.view.swing.SwingUI;

public class ClientDialog extends StandardDetailDialog implements ClientUI {

	private JTextField nameField;
	private AddressPanel addressPanel;

	public ClientDialog() {
		super(MessageId.client);
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		nameField = new JTextField();
		addressPanel = new AddressPanel();
		
		centerPanel().add(SwingUI.instance().label(nameField, MessageId.clientName));
		centerPanel().add(addressPanel);
	}

	public String getClientName() {
		return nameField.getText();
	}
	
	public void setClientName(String name) {
		nameField.setText(name);
	}

	public AddressUI getAddressUI() {
		return addressPanel;
	}
}
