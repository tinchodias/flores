package ui.view.swing.component.detail;

import javax.swing.JFormattedTextField;

import message.MessageId;
import model.money.MoneyAmount;
import model.stock.Article;
import ui.controller.manager.UIModelManager;
import ui.view.component.BuyItemUI;
import ui.view.swing.SwingUI;
import ui.view.swing.util.objectpicker3.ObjectPicker3;

public class BuyItemDialog extends StandardDetailDialog implements BuyItemUI {

	private JFormattedTextField countField;
	private JFormattedTextField valueField;
	private ObjectPicker3 articlePicker;

	public BuyItemDialog() {
		super(MessageId.buyItem);
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		countField = SwingUI.instance().decimalField();
		valueField = SwingUI.instance().currencyField();
		articlePicker = new ObjectPicker3();
		
		centerPanel().add(SwingUI.instance().decorated(articlePicker, MessageId.article));
		centerPanel().add(SwingUI.instance().decorated(countField, MessageId.count));
		centerPanel().add(SwingUI.instance().decorated(valueField, MessageId.unitCost));
	}

	public Article getArticle() {
		return (Article) articlePicker.getSelection();
	}

	public double getCount() {
		return SwingUI.instance().doubleFrom(countField);
	}

	public MoneyAmount getValue() {
		return SwingUI.instance().moneyAmountFrom(valueField);
	}

	public void setArticleManager(UIModelManager manager) {
		articlePicker.setUIModelManager(manager);
	}

}
