package ui.view.swing.component;

import javax.swing.JTextField;

import message.MessageId;
import query.criteria.StockArticleSearchCriteria;
import ui.view.swing.SwingUI;

public class StockArticleSearchPanel extends StandardSearchPanel implements StockArticleSearchCriteria {

	private JTextField descriptionField;

	public StockArticleSearchPanel() {
		initComponents();
	}

	private void initComponents() {
		descriptionField = new JTextField();
		
		this.filtersPanel().add(SwingUI.instance().label(descriptionField, MessageId.articleDescription));
	}

	public String getDescription() {
		return this.descriptionField.getText();
	}

}
