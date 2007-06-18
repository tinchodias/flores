package ui.view.swing.component;

import javax.swing.JTextField;

import message.MessageId;
import ui.UI;
import ui.view.component.ClientUI;

public class ClientDialog extends StandardDetailDialog implements ClientUI {

	private JTextField clientNameField;

	public ClientDialog() {
		super(MessageId.clientDialogTitle);
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		clientNameField = new JTextField();
		
		centerPanel().add(UI.instance().label(clientNameField, MessageId.clientName));
	}

	public String getClientName() {
		return clientNameField.getText();
	}
	
	public void setClientName(String name) {
		clientNameField.setText(name);
	}

}
