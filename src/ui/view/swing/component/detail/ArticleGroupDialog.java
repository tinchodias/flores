package ui.view.swing.component.detail;

import javax.swing.JTextField;

import message.MessageId;
import ui.view.component.ArticleGroupUI;
import ui.view.swing.SwingUI;

public class ArticleGroupDialog extends StandardDetailDialog implements ArticleGroupUI {

	private JTextField nameField;

	public ArticleGroupDialog() {
		super(MessageId.articleGroup);
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		nameField = new JTextField();
		
		centerPanel().add(SwingUI.instance().label(nameField, MessageId.name));
	}

	public String getArticleGroupName() {
		return nameField.getText();
	}
	
	public void setArticleGroupName(String name) {
		nameField.setText(name);
	}
}
