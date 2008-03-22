package ui.view.swing.component;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import message.IconRepository;
import message.MessageId;
import message.MessageRepository;
import ui.view.component.DialogUI;
import ui.view.swing.SwingUI;

public class StandardDialog extends JDialog implements DialogUI {

	private JPanel buttonPanel;
	private JPanel centerPanel;

	public StandardDialog(MessageId titleMessageId) {
		super(SwingUI.instance().mainUI(), ModalityType.DOCUMENT_MODAL);

		String title = MessageRepository.instance().get(titleMessageId);
		setTitle(title);

		ImageIcon icon = IconRepository.instance().get(titleMessageId);
		if (icon != null) {
			setIconImage(icon.getImage());
		}
		
		initComponents();
	}

	private void initComponents() {
		initCenterPanel();
		initButtonPanel();
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
	}

	private void initButtonPanel() {
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
	}

	private void initCenterPanel() {
		centerPanel = new JPanel();
		centerPanel.setBorder(new EmptyBorder(10, 10, 20, 10));
	}

	protected JPanel buttonPanel() {
		return buttonPanel;
	}

	protected JPanel centerPanel() {
		return centerPanel;
	}
	
}