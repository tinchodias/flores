package ui.view.swing.component;

import javax.swing.JTextField;

import message.MessageId;
import ui.view.component.StockDropOutUI;

public class StockDropOutDialog extends StandardDetailDialog implements StockDropOutUI {

	private JTextField clientNameField;

	public StockDropOutDialog() {
		super(MessageId.stockDropOutDialogTitle);
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
//		clientNameField = new JTextField();
//		
//		detailPanel().add(UI.instance().label(clientNameField, MessageId.clientName));
	}

	public String getClientName() {
		return clientNameField.getText();
	}
	
	public void setClientName(String name) {
		clientNameField.setText(name);
	}

}
