package ui.view.swing.component.search;

import javax.swing.JTextField;

import message.MessageId;
import query.criteria.CitySearchCriteria;
import ui.view.swing.SwingUI;

public class CitySearchPanel extends StandardSearchPanel implements CitySearchCriteria {

	private JTextField nameField;

	public CitySearchPanel() {
		initComponents();
	}

	private void initComponents() {
		nameField = new JTextField();
		
		filtersPanel().add(SwingUI.instance().decorated(nameField, MessageId.name));
	}

	public String getCityName() {
		return nameField.getText();
	}

}
