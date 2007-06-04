package ui.view.swing.component;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import message.MessageId;
import ui.controller.action.Action;
import ui.view.component.DetailUI;
import ui.view.swing.util.ActionAdapter;
import ui.view.swing.util.StandardDialog;

public abstract class StandardDetailDialog extends StandardDialog implements DetailUI {

	private JPanel detailPanel;
	private JButton okButton;
	private JButton cancelButton;

	public StandardDetailDialog(MessageId titleMessageId) {
		super(titleMessageId);
		initComponents();
		pack();
	}

	private void initComponents() {
		initDetailPanel();
		initButtons();
		
		this.centerPanel().setLayout(new FlowLayout(FlowLayout.LEFT));
		this.centerPanel().add(detailPanel);
	}

	private void initButtons() {
		okButton = new JButton();
		cancelButton = new JButton();

		buttonPanel().add(okButton);
		buttonPanel().add(cancelButton);
	}

	private void initDetailPanel() {
		detailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	}

	public JPanel detailPanel() {
		return detailPanel;
	}

	public void setCreateAction(Action action) {
		okButton.setAction(new ActionAdapter(action));
	}

	public void setModifyAction(Action action) {
		okButton.setAction(new ActionAdapter(action));
	}
	
	public void setCancelAction(Action action) {
		cancelButton.setAction(new ActionAdapter(action));
	}

}
