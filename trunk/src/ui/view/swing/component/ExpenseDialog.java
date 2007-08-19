package ui.view.swing.component;

import javax.swing.JFormattedTextField;

import message.MessageId;
import model.expense.ExpenseArticle;
import model.money.Pesos;
import ui.controller.initializer.search.SearchDialogInitializer;
import ui.view.component.ExpenseUI;
import ui.view.swing.SwingUI;
import ui.view.swing.util.objectpicker.ObjectPicker;

public class ExpenseDialog extends StandardDetailDialog implements ExpenseUI {

	private ObjectPicker expenseArticlePicker;
	private JFormattedTextField costField;

	public ExpenseDialog() {
		super(MessageId.expense);
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		expenseArticlePicker = new ObjectPicker();
		costField = SwingUI.instance().currencyField();
		
		centerPanel().add(SwingUI.instance().label(expenseArticlePicker, MessageId.expenseArticle));
		centerPanel().add(SwingUI.instance().label(costField, MessageId.cashPay));
	}

	public Pesos getCost() {
		return SwingUI.instance().pesosFrom(costField);
	}

	public ExpenseArticle getExpenseArticle() {
		return (ExpenseArticle) expenseArticlePicker.getSelection();
	}

	public void setExpenseArticleSearchInitializer(SearchDialogInitializer initializer) {
		expenseArticlePicker.setSearchInitializer(initializer);
	}
	
}
