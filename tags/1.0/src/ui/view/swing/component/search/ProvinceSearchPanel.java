package ui.view.swing.component.search;

import javax.swing.JTextField;

import message.MessageId;
import query.criteria.ProvinceSearchCriteria;
import ui.view.swing.SwingUI;

public class ProvinceSearchPanel extends StandardSearchPanel implements ProvinceSearchCriteria {

	private JTextField provinceNameField;

	public ProvinceSearchPanel() {
		initComponents();
	}

	private void initComponents() {
		provinceNameField = new JTextField();
		
		this.filtersPanel().add(SwingUI.instance().decorated(provinceNameField, MessageId.clientName));
	}

	public String getProvinceName() {
		return provinceNameField.getText();
	}

}
