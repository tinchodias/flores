package ui.view.swing.component;

import javax.swing.JTextField;

import message.MessageId;
import model.money.Pesos;
import model.stock.Article;
import ui.UI;
import ui.controller.initializer.SearchDialogInitializer;
import ui.view.component.BuyItemUI;
import ui.view.swing.util.ObjectPicker;

public class BuyItemDialog extends StandardDetailDialog implements BuyItemUI {

	private ObjectPicker articlePicker;
	private JTextField countField;
	private JTextField valueField;

	public BuyItemDialog() {
		super(MessageId.buyItem);
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		articlePicker = new ObjectPicker();
		countField = UI.instance().decimalTextField();
		valueField = UI.instance().decimalTextField();
		
		centerPanel().add(UI.instance().label(articlePicker, MessageId.article));
		centerPanel().add(UI.instance().label(countField, MessageId.count));
		centerPanel().add(UI.instance().label(valueField, MessageId.value));
	}
	
	public void setArticleSearchInitializer(SearchDialogInitializer initializer) {
		articlePicker.setSearchInitializer(initializer);		
	}

	public Article getArticle() {
		return (Article) articlePicker.getSelection();
	}

	public double getCount() {
		return Double.parseDouble(countField.getText());
	}

	public Pesos getValue() {
		double value = Double.parseDouble(valueField.getText());
		return Pesos.newFor(value);
	}
	
}
