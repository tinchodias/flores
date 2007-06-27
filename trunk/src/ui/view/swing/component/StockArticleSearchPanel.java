package ui.view.swing.component;

import javax.swing.JTextField;

import message.MessageId;
import query.criteria.StockArticleSearchCriteria;
import ui.view.swing.SwingUI;

public class StockArticleSearchPanel extends StandardSearchPanel implements StockArticleSearchCriteria {

	private JTextField nameField;

	public StockArticleSearchPanel() {
		initComponents();
	}

	private void initComponents() {
		nameField = new JTextField();
		
		this.filtersPanel().add(SwingUI.instance().label(nameField, MessageId.name));
	}

	public String getArticleName() {
		return this.nameField.getText();
	}

}
