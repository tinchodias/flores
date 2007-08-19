package ui.view.swing.component.detail;

import javax.swing.JTextField;

import message.MessageId;
import model.stock.ArticleGroup;
import ui.controller.initializer.search.SearchDialogInitializer;
import ui.view.component.ArticleUI;
import ui.view.swing.SwingUI;
import ui.view.swing.util.objectpicker.ObjectPicker;

public class ArticleDialog extends StandardDetailDialog implements ArticleUI {

	private JTextField codeField;
	private JTextField nameField;
	private JTextField sizeField;
	private ObjectPicker groupPicker;

	public ArticleDialog() {
		super(MessageId.article);
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		codeField = new JTextField();
		nameField = new JTextField();
		sizeField = new JTextField();
		groupPicker = new ObjectPicker();
		
		centerPanel().add(SwingUI.instance().label(codeField, MessageId.code));
		centerPanel().add(SwingUI.instance().label(nameField, MessageId.name));
		centerPanel().add(SwingUI.instance().label(sizeField, MessageId.size));
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

	public String getCode() {
		return codeField.getText();
	}

	public String getArticleSize() {
		return sizeField.getText();
	}

	public void setArticleGroup(ArticleGroup articleGroup) {
		groupPicker.setSelection(articleGroup);
	}

	public void setArticleName(String name) {
		nameField.setText(name);
	}

	public void setCode(String code) {
		codeField.setText(code);
	}

	public void setArticleSize(String size) {
		sizeField.setText(size);
	}

}
