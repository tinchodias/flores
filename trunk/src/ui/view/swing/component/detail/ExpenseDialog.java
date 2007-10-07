package ui.view.swing.component.detail;

import javax.swing.JFormattedTextField;

import message.MessageId;
import model.expense.ExpenseArticle;
import model.money.MoneyAmount;
import ui.controller.manager.UIModelManager;
import ui.view.component.ExpenseUI;
import ui.view.swing.SwingUI;
import ui.view.swing.util.objectpicker3.ObjectPicker3;

public class ExpenseDialog extends StandardDetailDialog implements ExpenseUI {

	private ObjectPicker3 expenseArticlePicker;
	private JFormattedTextField costField;

	public ExpenseDialog() {
		super(MessageId.expense);
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		expenseArticlePicker = new ObjectPicker3();
		costField = SwingUI.instance().currencyField();
		
		centerPanel().add(SwingUI.instance().label(expenseArticlePicker, MessageId.expenseArticle));
		centerPanel().add(SwingUI.instance().label(costField, MessageId.cashPay));
	}

	public MoneyAmount getCost() {
		return SwingUI.instance().moneyAmountFrom(costField);
	}

	public ExpenseArticle getExpenseArticle() {
		return (ExpenseArticle) expenseArticlePicker.getSelection();
	}

	public void setExpenseArticleManager(UIModelManager manager) {
		expenseArticlePicker.setUIModelManager(manager);
	}
	
}
