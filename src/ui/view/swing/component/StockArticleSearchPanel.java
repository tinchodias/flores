package ui.view.swing.component;

import javax.swing.JTextField;

import message.MessageId;
import model.stock.ArticleGroup;
import query.criteria.StockArticleSearchCriteria;
import ui.UI;
import ui.controller.action.Action;
import ui.view.swing.util.ActionAdapter;

public class StockArticleSearchPanel extends StandardSearchPanel implements StockArticleSearchCriteria {

	private JTextField codeField;
	private JTextField descriptionField;

	public StockArticleSearchPanel() {
		initComponents();
	}

	private void initComponents() {
		codeField = new JTextField();
		descriptionField = new JTextField();
		
		this.filtersPanel().add(UI.instance().label(codeField, MessageId.articleCode));
		this.filtersPanel().add(UI.instance().label(descriptionField, MessageId.articleDescription));
	}

	public void setSearchAction(Action action) {
		ActionAdapter actionAdapter = new ActionAdapter(action);
		codeField.addActionListener(actionAdapter);
		descriptionField.addActionListener(actionAdapter);
	}

	public String getCode() {
		return this.codeField.getText();
	}

	public String getDescription() {
		return this.descriptionField.getText();
	}

	public ArticleGroup getGroup() {
		// TODO Auto-generated method stub
		return null;
	}

}
