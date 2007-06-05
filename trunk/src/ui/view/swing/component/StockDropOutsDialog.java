package ui.view.swing.component;

import java.awt.BorderLayout;

import javax.swing.JButton;

import message.MessageId;
import ui.controller.action.Action;
import ui.view.component.StockDropOutsUI;
import ui.view.swing.util.ActionAdapter;
import ui.view.swing.util.StandardDialog;

public class StockDropOutsDialog extends StandardDialog implements StockDropOutsUI {

	private StockDropOutSearchPanel searchPanel;
	private JButton okButton;
	private JButton createButton;

	public StockDropOutsDialog() {
		super(MessageId.stockDropDownsDialogTitle);
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
		searchPanel = new StockDropOutSearchPanel();  
		createButton = new JButton();
		
		searchPanel.buttonPanel().add(createButton);
	}

	public StandardSearchPanel getSearchPanel() {
		return searchPanel;
	}

	public void setOkAction(Action action) {
		okButton.setAction(new ActionAdapter(action));
	}

	public void setCreateAction(Action action) {
		createButton.setAction(new ActionAdapter(action));	
	}
	
}
