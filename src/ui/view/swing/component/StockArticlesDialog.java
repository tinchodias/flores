package ui.view.swing.component;

import java.awt.BorderLayout;

import javax.swing.JButton;

import message.MessageId;
import ui.controller.action.Action;
import ui.view.component.StockArticlesUI;
import ui.view.swing.util.ActionAdapter;
import ui.view.swing.util.StandardDialog;

public class StockArticlesDialog extends StandardDialog implements StockArticlesUI {

	private StockArticleSearchPanel searchPanel;
	private JButton okButton;
	private JButton createButton;
	private JButton modifyButton;

	public StockArticlesDialog() {
		super(MessageId.stockDialogTitle);
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		initSearchPanel();

		okButton = new JButton();
		
		this.centerPanel().setLayout(new BorderLayout());
		this.centerPanel().add(searchPanel, BorderLayout.CENTER);
		this.buttonPanel().add(okButton);
	}

	private void initSearchPanel() {
		searchPanel = new StockArticleSearchPanel();  
		createButton = new JButton();
		modifyButton = new JButton();
		
		searchPanel.buttonPanel().add(createButton);
		searchPanel.buttonPanel().add(modifyButton);
	}

	public StockArticleSearchPanel getSearchPanel() {
		return searchPanel;
	}

	public void setShowBuysAction(Action action) {
		createButton.setAction(new ActionAdapter(action));
	}

	public void setShowStockDropDownsAction(Action action) {
		modifyButton.setAction(new ActionAdapter(action));
	}

	public void setOkAction(Action action) {
		okButton.setAction(new ActionAdapter(action));
	}
	
}
