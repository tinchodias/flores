package ui.view.swing.component.detail;

import javax.swing.JTextField;

import message.MessageId;
import ui.view.component.AddressUI;
import ui.view.component.ClientUI;
import ui.view.swing.SwingUI;
import ui.view.swing.component.AddressPanel;

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
		centerPanel().add(SwingUI.instance().titledBorderPanel(addressPanel, MessageId.mainAddress));
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
