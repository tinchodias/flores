package ui.view.swing.component;

import java.awt.FlowLayout;

import javax.swing.JButton;

import message.MessageId;
import ui.controller.action.Action;
import ui.view.component.DetailUI;
import ui.view.swing.util.ActionAdapter;
import ui.view.swing.util.StandardDialog;

public abstract class StandardDetailDialog extends StandardDialog implements DetailUI {

	private JButton okButton;
	private JButton cancelButton;

	public StandardDetailDialog(MessageId titleMessageId) {
		super(titleMessageId);
		initComponents();
	}

	private void initComponents() {
		initButtons();
		
		this.centerPanel().setLayout(new FlowLayout(FlowLayout.LEFT));
	}

	private void initButtons() {
		okButton = new JButton();
		cancelButton = new JButton();

		getRootPane().setDefaultButton(okButton);
		
		buttonPanel().add(okButton);
		buttonPanel().add(cancelButton);
	}

	public void setAcceptAction(Action action) {
		okButton.setAction(new ActionAdapter(action));
	}
	
	public void setCancelAction(Action action) {
		cancelButton.setAction(new ActionAdapter(action));
	}

}
