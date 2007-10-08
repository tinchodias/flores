package ui.view.swing.component.detail;

import javax.swing.JTextField;

import message.MessageId;
import ui.view.component.ExpenseArticleUI;
import ui.view.swing.SwingUI;

public class ExpenseArticleDialog extends StandardDetailDialog implements ExpenseArticleUI {

	private JTextField nameField;

	public ExpenseArticleDialog() {
		super(MessageId.expenseArticle);
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		nameField = new JTextField();
		
		centerPanel().add(SwingUI.instance().decorated(nameField, MessageId.name));
	}

	public String getArticleName() {
		return nameField.getText();
	}

	public void setArticleName(String name) {
		nameField.setText(name);
	}

}
