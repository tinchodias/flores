package ui.view.swing.component.search;

import javax.swing.JTextField;

import message.MessageId;
import query.criteria.ArticleGroupSearchCriteria;
import ui.view.swing.SwingUI;

public class ArticleGroupSearchPanel extends StandardSearchPanel implements ArticleGroupSearchCriteria {

	private JTextField nameField;

	public ArticleGroupSearchPanel() {
		initComponents();
	}

	private void initComponents() {
		nameField = new JTextField();
		
		filtersPanel().add(SwingUI.instance().label(nameField, MessageId.name));
	}

	public String getArticleGroupName() {
		return nameField.getText();
	}

}
