package ui.view.swing.component.detail;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

import message.MessageId;
import model.money.MoneyAmount;
import model.stock.Article;
import ui.controller.action.Action;
import ui.controller.manager.UIModelManager;
import ui.view.component.SellItemUI;
import ui.view.swing.SwingUI;
import ui.view.swing.util.actionadapter.SelectionListenerAdapter;
import ui.view.swing.util.objectpicker3.ObjectPicker3;

public class SellItemDialog extends StandardDetailDialog implements SellItemUI {

	private ObjectPicker3 articlePicker;
	private JFormattedTextField countField;
	private JFormattedTextField valueField;
	private JLabel costLabel;
	private JLabel stockCountLabel;

	public SellItemDialog() {
		super(MessageId.sellItem);
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		articlePicker = new ObjectPicker3();
		countField = SwingUI.instance().decimalField();
		valueField = SwingUI.instance().currencyField();
		costLabel = new JLabel(" ");
		stockCountLabel = new JLabel(" ");
		
		centerPanel().add(SwingUI.instance().label(articlePicker, MessageId.article));
		centerPanel().add(SwingUI.instance().label(countField, MessageId.count));
		centerPanel().add(SwingUI.instance().label(valueField, MessageId.unitPrice));
		centerPanel().add(SwingUI.instance().label(stockCountLabel, MessageId.stockCount));
		centerPanel().add(SwingUI.instance().label(costLabel, MessageId.unitCost));
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

	public void addOnArticleSelectionAction(Action action) {
		articlePicker.addSelectionListener(new SelectionListenerAdapter(action));
	}

	public void setValue(double value) {
		valueField.setValue(value);
	}

	public void setCount(double count) {
		countField.setValue(count);
	}

	public void setArticleManager(UIModelManager manager) {
		articlePicker.setUIModelManager(manager);
	}

	public void setCost(String cost) {
		costLabel.setText(cost);
	}
	
	public void setStockCount(String count) {
		stockCountLabel.setText(count);
	}
	
}
