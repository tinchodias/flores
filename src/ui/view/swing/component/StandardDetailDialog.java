package ui.view.swing.component;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import message.MessageId;
import ui.controller.action.Action;
import ui.view.component.DetailUI;
import ui.view.swing.util.ActionAdapter;
import ui.view.swing.util.StandardDialog;

public abstract class StandardDetailDialog extends StandardDialog implements DetailUI {

//	private ViewMode viewMode;
	private JPanel detailPanel;
	private JButton okButton;
	private JButton cancelButton;

	public StandardDetailDialog(MessageId titleMessageId) {
		super(titleMessageId);
		initComponents();
	}

	private void initComponents() {
		initDetailPanel();
		initButtons();
		
		this.centerPanel().setLayout(new BorderLayout());
		this.centerPanel().add(detailPanel, BorderLayout.CENTER);
	}

	private void initButtons() {
		okButton = new JButton();
		cancelButton = new JButton();

		buttonPanel().add(okButton);
		buttonPanel().add(cancelButton);
	}

	private void initDetailPanel() {
		detailPanel = new JPanel();
		detailPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
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

//	public ViewMode viewMode() {
//		return viewMode;
//	}
//
//	public void viewMode(ViewMode viewMode) {
//		this.viewMode = viewMode;
//		//TODO agregarse como listener al modo?
//		viewModeChanged();
//	}
//	
//	private void viewModeChanged() {
//		Component[] components = this.detailPanel().getComponents();
//		for (int i = 0; i < components.length; i++) {
//			Component component = components[i];
//
//			component.setVisible(viewMode.isVisible(component));
//			component.setEnabled(viewMode.isEnabled(component));
//		} 
//	}

}
