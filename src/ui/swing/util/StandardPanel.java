package ui.swing.util;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class StandardPanel extends JPanel {

	private JPanel buttonPanel;
	private JPanel centerPanel;

	public StandardPanel() {
		super();
		this.setLayout(new BorderLayout());

		initCenterPanel();
		initButtonPanel();
		
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
	}

	private void initButtonPanel() {
		buttonPanel = new JPanel();
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