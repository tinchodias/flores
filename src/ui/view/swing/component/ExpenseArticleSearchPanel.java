package ui.view.swing.component;

import javax.swing.JTextField;

import message.MessageId;
import query.criteria.ExpenseArticleSearchCriteria;
import ui.view.swing.SwingUI;

public class ExpenseArticleSearchPanel extends StandardSearchPanel implements ExpenseArticleSearchCriteria {

	private JTextField nameField;

	public ExpenseArticleSearchPanel() {
		initComponents();
	}

	private void initComponents() {
		nameField = new JTextField();
		
		filtersPanel().add(SwingUI.instance().label(nameField, MessageId.name));
	}

	public String getArticleName() {
		return nameField.getText();
	}

}
