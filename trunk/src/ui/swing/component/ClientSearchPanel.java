package ui.swing.component;

import javax.swing.JTextField;

import message.MessageIdentifier;
import query.criteria.ClientSearchCriteria;
import ui.UI;
import ui.action.ClientSearchAction;
import ui.swing.util.ActionAdapter;

public class ClientSearchPanel extends StandardSearchPanel implements ClientSearchCriteria {

	private JTextField clientNameField;

	public ClientSearchPanel() {
		initComponents();
	}

	private void initComponents() {
		clientNameField = new JTextField();
		
		this.filtersPanel().add(UI.instance().label(clientNameField, MessageIdentifier.CLIENT_NAME));
	}

	public void setSearchAction(ClientSearchAction action) {
		clientNameField.addActionListener(new ActionAdapter(action));
	}

	public String getClientName() {
		return clientNameField.getText();
	}

	public ClientSearchCriteria criteria() {
		return this;
	}

}
