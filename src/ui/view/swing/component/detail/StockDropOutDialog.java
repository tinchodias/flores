package ui.view.swing.component.detail;

import javax.swing.JFormattedTextField;

import message.MessageId;
import model.stock.Article;
import ui.controller.initializer.search.SearchDialogInitializer;
import ui.view.component.StockDropOutUI;
import ui.view.swing.SwingUI;
import ui.view.swing.util.objectpicker.ObjectPicker;

public class StockDropOutDialog extends StandardDetailDialog implements StockDropOutUI {

	private JFormattedTextField countField;
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
		return SwingUI.instance().doubleFrom(countField);
	}

	public Article getArticle() {
		return (Article) articlePicker.getSelection();
	}

	public void setArticleSearchInitializer(SearchDialogInitializer initializer) {
		articlePicker.setSearchInitializer(initializer);		
	}
	
}
