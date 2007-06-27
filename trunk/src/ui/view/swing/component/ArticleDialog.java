package ui.view.swing.component;

import javax.swing.JTextField;

import message.MessageId;
import model.stock.ArticleGroup;
import ui.controller.initializer.SearchDialogInitializer;
import ui.view.component.ArticleUI;
import ui.view.swing.SwingUI;
import ui.view.swing.util.objectpicker.ObjectPicker;

public class ArticleDialog extends StandardDetailDialog implements ArticleUI {

	private JTextField nameField;
	private ObjectPicker groupPicker;

	public ArticleDialog() {
		super(MessageId.article);
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		nameField = new JTextField();
		groupPicker = new ObjectPicker();
		
		centerPanel().add(SwingUI.instance().label(nameField, MessageId.name));
		centerPanel().add(SwingUI.instance().label(groupPicker, MessageId.articleGroup));
	}

	public ArticleGroup getArticleGroup() {
		return (ArticleGroup) groupPicker.getSelection();
	}

	public String getArticleName() {
		return nameField.getText();
	}

	public void setArticleGroupSearchInitializer(SearchDialogInitializer initializer) {
		groupPicker.setSearchInitializer(initializer);
	}

}
