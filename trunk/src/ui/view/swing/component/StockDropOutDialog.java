package ui.view.swing.component;

import javax.swing.JTextField;

import message.MessageId;
import model.stock.Article;
import ui.controller.initializer.SearchDialogInitializer;
import ui.view.component.StockDropOutUI;
import ui.view.swing.SwingUI;
import ui.view.swing.util.ObjectPicker;

public class StockDropOutDialog extends StandardDetailDialog implements StockDropOutUI {

	private JTextField countField;
	private ObjectPicker articlePicker;

	public StockDropOutDialog() {
		super(MessageId.stockDropOutDialogTitle);
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		articlePicker = new ObjectPicker();
		countField = SwingUI.instance().decimalField();
		
		centerPanel().add(SwingUI.instance().label(articlePicker, MessageId.article));
		centerPanel().add(SwingUI.instance().label(countField, MessageId.count));
	}

	public double getCount() {
		return Double.parseDouble(countField.getText());
	}

	public Article getArticle() {
		return (Article) articlePicker.getSelection();
	}

	public void setArticleSearchInitializer(SearchDialogInitializer initializer) {
		articlePicker.setSearchInitializer(initializer);		
	}
	
}