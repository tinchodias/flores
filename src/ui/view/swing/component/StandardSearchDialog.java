package ui.view.swing.component;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;

import message.MessageId;
import ui.controller.action.Action;
import ui.view.component.SearchDialogUI;
import ui.view.swing.util.actionadapter.ActionAdapter;

public class StandardSearchDialog extends StandardDialog implements SearchDialogUI {

	private StandardSearchPanel searchPanel;
	private JButton closeButton;

	public StandardSearchDialog(MessageId titleMessageId, StandardSearchPanel searchPanel) {
		super(titleMessageId);
		this.searchPanel = searchPanel;  
		initComponents();
		setPreferredSize(new Dimension(640, 480));
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		closeButton = new JButton();
		
		this.centerPanel().setLayout(new BorderLayout());
		this.centerPanel().add(searchPanel, BorderLayout.CENTER);
		this.buttonPanel().add(closeButton);
	}

	public void setCloseAction(Action action) {
		closeButton.setAction(new ActionAdapter(action));
	}

	public StandardSearchPanel getSearchPanel() {
		return searchPanel;
	}

}
