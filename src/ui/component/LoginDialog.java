package ui.component;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginDialog extends JDialog {

	private LabeledPanel name;
	private LabeledPanel password;
	private JButton loginButton;
	private JPanel centerPanel;

	public LoginDialog(JFrame frame) {
		super(frame);
		init();
		initComponents();
		pack();
//		this.setLocationRelativeTo(frame);
	}

	private void init() {
		this.setModal(true);
		this.setLayout(new BorderLayout());
	}

	private void initComponents() {
		name = new LabeledPanel(new JTextField("martin"));
		password = new LabeledPanel(new JPasswordField("123456"));
		loginButton = new JButton();
		
		centerPanel = new JPanel();
		centerPanel.add(name);
		centerPanel.add(password);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(loginButton, BorderLayout.SOUTH);

		setTitle("Login");
		name.setTitle("Nombre:");
		password.setTitle("Clave:");
		loginButton.setText("Aceptar");
	}

}
