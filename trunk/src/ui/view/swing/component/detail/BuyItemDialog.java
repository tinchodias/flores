package ui.view.swing.component.detail;

import javax.swing.JFormattedTextField;

import message.MessageId;
import model.money.Pesos;
import model.stock.Article;
import persistence.ModelPersistence;
import query.QueryFactory;
import ui.controller.initializer.search.SearchDialogInitializer;
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
		
		//TODO put this in the correct place
		articlePicker = new ObjectPicker3();
		Iterable items = ModelPersistence.instance().loadedModel().store().stockArticles();
		articlePicker.setQuery(QueryFactory.instance().stringSearchQuery(items));
		
		centerPanel().add(SwingUI.instance().label(articlePicker, MessageId.article));
		centerPanel().add(SwingUI.instance().label(countField, MessageId.count));
		centerPanel().add(SwingUI.instance().label(valueField, MessageId.articleCost));
	}
	
	public void setArticleSearchInitializer(SearchDialogInitializer initializer) {
		articlePicker.setSearchInitializer(initializer);		
	}

	public Article getArticle() {
		return (Article) articlePicker.getSelection();
	}

	public double getCount() {
		return SwingUI.instance().doubleFrom(countField);
	}

	public Pesos getValue() {
		return SwingUI.instance().pesosFrom(valueField);
	}

}
