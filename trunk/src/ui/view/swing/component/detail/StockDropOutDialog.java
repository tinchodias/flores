package ui.view.swing.component.detail;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import message.MessageId;
import model.stock.Article;
import ui.controller.manager.UIModelManager;
import ui.view.component.StockDropOutUI;
import ui.view.swing.SwingUI;
import ui.view.swing.util.objectpicker3.ObjectPicker3;

public class StockDropOutDialog extends StandardDetailDialog implements StockDropOutUI {

	private JFormattedTextField countField;
	private ObjectPicker3 articlePicker;
	private JTextField noteField;

	public StockDropOutDialog() {
		super(MessageId.stockDropOut);
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		articlePicker = new ObjectPicker3();
		countField = SwingUI.instance().decimalField();
		noteField = new JTextField();
		
		centerPanel().add(SwingUI.instance().decorated(articlePicker, MessageId.article));
		centerPanel().add(SwingUI.instance().decorated(countField, MessageId.count));
		centerPanel().add(SwingUI.instance().decorated(noteField, MessageId.note));
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

	public String getNote() {
		return noteField.getText();
	}
	
}
