package ui.swing.util;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JPanel;

import ui.UI;

public class StandardDialog extends JDialog {

	private JPanel buttonPanel;
	private JPanel centerPanel;

	public StandardDialog() {
		//TODO ver este cast..
		super((Window) UI.instance().mainUI(), ModalityType.APPLICATION_MODAL);

		initCenterPanel();
		initButtonPanel();
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
	}

	private void initButtonPanel() {
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	}

	private void initCenterPanel() {
		centerPanel = new JPanel();
	}

	protected JPanel buttonPanel() {
		return buttonPanel;
	}

	protected JPanel centerPanel() {
		return centerPanel;
	}
	
}