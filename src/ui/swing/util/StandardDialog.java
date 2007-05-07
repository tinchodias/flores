package ui.swing.util;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JPanel;

import message.MessageId;
import message.MessageRepository;
import ui.UI;

public class StandardDialog extends JDialog {

	private JPanel buttonPanel;
	private JPanel centerPanel;

	public StandardDialog(MessageId messageIdentifier) {
		//TODO ver este cast..
		super((Window) UI.instance().mainUI(), ModalityType.APPLICATION_MODAL);

		String title = MessageRepository.instance().messageFor(messageIdentifier);
		setTitle(title);
		
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