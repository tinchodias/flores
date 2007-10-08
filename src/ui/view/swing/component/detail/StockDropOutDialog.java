package ui.view.swing.component.detail;

import javax.swing.JFormattedTextField;

import message.MessageId;
import model.stock.Article;
import ui.controller.manager.UIModelManager;
import ui.view.component.StockDropOutUI;
import ui.view.swing.SwingUI;
import ui.view.swing.util.objectpicker3.ObjectPicker3;

public class StockDropOutDialog extends StandardDetailDialog implements StockDropOutUI {

	private JFormattedTextField countField;
	private ObjectPicker3 articlePicker;

	public StockDropOutDialog() {
		super(MessageId.stockDropOutDialogTitle);
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		articlePicker = new ObjectPicker3();
		countField = SwingUI.instance().decimalField();
		
		centerPanel().add(SwingUI.instance().decorated(articlePicker, MessageId.article));
		centerPanel().add(SwingUI.instance().decorated(countField, MessageId.count));
	}

	public double getCount() {
		return SwingUI.instance().doubleFrom(countField);
	}

	public Article getArticle() {
		return (Article) articlePicker.getSelection();
	}

	public void setArticleManager(UIModelManager manager) {
		articlePicker.setUIModelManager(manager);
	}
	
}
