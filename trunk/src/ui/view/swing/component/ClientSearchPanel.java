package ui.view.swing.component;

import javax.swing.JTextField;

import message.MessageId;
import query.criteria.ClientSearchCriteria;
import ui.UI;
import ui.controller.action.Action;
import ui.view.swing.util.ActionAdapter;

public class ClientSearchPanel extends StandardSearchPanel implements ClientSearchCriteria {

	private JTextField clientNameField;

	public ClientSearchPanel() {
		initComponents();
	}

	private void initComponents() {
		clientNameField = new JTextField();
		
		this.filtersPanel().add(UI.instance().label(clientNameField, MessageId.clientName));
	}

	public void setSearchAction(Action action) {
		clientNameField.addActionListener(new ActionAdapter(action));
	}

	public String getClientName() {
		return clientNameField.getText();
	}

	public ClientSearchCriteria criteria() {
		return this;
	}

}
