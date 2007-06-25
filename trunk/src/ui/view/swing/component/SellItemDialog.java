package ui.view.swing.component;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

import message.MessageId;
import model.money.Pesos;
import model.stock.Article;
import ui.controller.action.Action;
import ui.controller.initializer.SearchDialogInitializer;
import ui.view.component.SellItemUI;
import ui.view.swing.SwingUI;
import ui.view.swing.util.actionadapter.SelectionListenerAdapter;
import ui.view.swing.util.objectpicker.ObjectPicker;

public class SellItemDialog extends StandardDetailDialog implements SellItemUI {

	private ObjectPicker articlePicker;
	private JFormattedTextField countField;
	private JFormattedTextField valueField;
	private JLabel costLabel;

	public SellItemDialog() {
		super(MessageId.sellItem);
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		articlePicker = new ObjectPicker();
		countField = SwingUI.instance().decimalField();
		valueField = SwingUI.instance().currencyField();
		costLabel = new JLabel(" ");
		
		centerPanel().add(SwingUI.instance().label(articlePicker, MessageId.article));
		centerPanel().add(SwingUI.instance().label(countField, MessageId.count));
		centerPanel().add(SwingUI.instance().label(valueField, MessageId.value));
		centerPanel().add(SwingUI.instance().label(costLabel, MessageId.articleCost));
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

	public void setCostAction(Action action) {
		articlePicker.addSelectionListener(new SelectionListenerAdapter(action));
	}

	public void setCost(String cost) {
		costLabel.setText(cost);
	}
	
}
