package ui;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UI {

	private static UI instance;

	public static UI instance() {
		if (instance == null) {
			instance = new UI();
		}
		return instance;
	}

	public void showInfo(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public void showError(Container container, String message) {
		JOptionPane.showMessageDialog(container, message, "", JOptionPane.ERROR_MESSAGE);		
	}

}
