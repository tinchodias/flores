package ui.view.swing.component.detail;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import message.MessageId;
import ui.controller.action.Action;
import ui.controller.initializer.detail.mode.DetailMode;
import ui.controller.initializer.detail.mode.DetailModeVisitor;
import ui.view.component.DetailUI;
import ui.view.swing.SwingUI;
import ui.view.swing.component.StandardDialog;
import ui.view.swing.util.actionadapter.ActionAdapter;

public abstract class StandardDetailDialog extends StandardDialog implements DetailUI, DetailModeVisitor {

	private JButton okButton;
	private JButton cancelButton;

	public StandardDetailDialog(MessageId titleMessageId) {
		super(titleMessageId);
		initComponents();
	}

	private void initComponents() {
		initButtons();
		
//		this.centerPanel().setLayout(new FlowLayout(FlowLayout.LEFT));
		this.centerPanel().setLayout(new BoxLayout(centerPanel(), BoxLayout.PAGE_AXIS));
	}

	private void initButtons() {
		cancelButton = new JButton();
		okButton = new JButton();
		okButton.setVisible(false);
		

		getRootPane().setDefaultButton(okButton);
		
		buttonPanel().add(SwingUI.instance().decorated(okButton));
		buttonPanel().add(SwingUI.instance().decorated(cancelButton));
	}

	public void setAcceptAction(Action action) {
		okButton.setVisible(true);
		okButton.setAction(new ActionAdapter(action));
	}
	
	public void setCancelAction(Action action) {
		cancelButton.setAction(new ActionAdapter(action));
	}

	public void setMode(DetailMode mode) {
		mode.applyTo(this);
	}
	
	public void setCreatingMode() {
	}
	
	public void setModifyingMode() {
	}
	
	public void setViewingMode() {
		SwingUI.instance().setEnableRecursively(this, false);
		okButton.setEnabled(true);
		cancelButton.setEnabled(true);
	}

}
