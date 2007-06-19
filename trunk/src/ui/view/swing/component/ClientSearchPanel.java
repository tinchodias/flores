package ui.view.swing.component;

import javax.swing.JTextField;

import message.MessageId;
import query.criteria.ClientSearchCriteria;
import ui.view.swing.SwingUI;

public class ClientSearchPanel extends StandardSearchPanel implements ClientSearchCriteria {

	private JTextField clientNameField;

	public ClientSearchPanel() {
		initComponents();
	}

	private void initComponents() {
		clientNameField = new JTextField();
		
		this.filtersPanel().add(SwingUI.instance().label(clientNameField, MessageId.clientName));
	}

	public String getClientName() {
		return clientNameField.getText();
	}

}
