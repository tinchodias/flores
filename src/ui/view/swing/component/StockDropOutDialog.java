package ui.view.swing.component;

import javax.swing.JTextField;

import message.MessageId;
import model.stock.Article;
import ui.UI;
import ui.controller.initializer.StockDialogInitializer;
import ui.view.component.StockDropOutUI;
import ui.view.swing.util.ObjectPicker;

public class StockDropOutDialog extends StandardDetailDialog implements StockDropOutUI {

	private JTextField countField;
	private ObjectPicker articlePicker;

	public StockDropOutDialog() {
		super(MessageId.stockDropOutDialogTitle);
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		articlePicker = new ObjectPicker();
		//TODO put this in the initiailzer! 
		articlePicker.setSearchInitializer(new StockDialogInitializer());
		
		countField = new JTextField();
		
		detailPanel().add(UI.instance().label(articlePicker, MessageId.article));
		detailPanel().add(UI.instance().label(countField, MessageId.count));
	}

	public double getCount() {
		double count = 0;
		
		//TODO when validate?
		try {
			count = Double.parseDouble(countField.getText());
		} catch (NumberFormatException e) {
		}
		return count;
	}

	public Article getArticle() {
		return (Article) articlePicker.getSelection();
	}

}
