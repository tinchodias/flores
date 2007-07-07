package ui.view.swing.component;

import javax.swing.JFormattedTextField;

import message.MessageId;
import model.money.Pesos;
import model.stock.Article;
import ui.controller.initializer.search.SearchDialogInitializer;
import ui.view.component.BuyItemUI;
import ui.view.swing.SwingUI;
import ui.view.swing.util.objectpicker.ObjectPicker;

public class BuyItemDialog extends StandardDetailDialog implements BuyItemUI {

	private ObjectPicker articlePicker;
	private JFormattedTextField countField;
	private JFormattedTextField valueField;

	public BuyItemDialog() {
		super(MessageId.buyItem);
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		articlePicker = new ObjectPicker();
		countField = SwingUI.instance().decimalField();
		valueField = SwingUI.instance().currencyField();
		
		centerPanel().add(SwingUI.instance().label(articlePicker, MessageId.article));
		centerPanel().add(SwingUI.instance().label(countField, MessageId.count));
		centerPanel().add(SwingUI.instance().label(valueField, MessageId.value));
	}
	
	public void setArticleSearchInitializer(SearchDialogInitializer initializer) {
		articlePicker.setSearchInitializer(initializer);		
	}

	public Article getArticle() {
		return (Article) articlePicker.getSelection();
	}

	public double getCount() {
		return Double.valueOf(countField.getValue().toString());
	}

	public Pesos getValue() {
		return SwingUI.instance().pesosFrom(valueField);
	}
	
}
