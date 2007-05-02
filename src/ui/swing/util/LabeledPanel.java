package ui.swing.util;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LabeledPanel extends JPanel {

	private JLabel label;
	private final JComponent component;

	public LabeledPanel(JComponent component) {
		this.component = component;
		initPanel();
		add(component, BorderLayout.CENTER);
	}

	private void initPanel() {
		setBorder(null);
		setLayout(new BorderLayout());
		
		label = new JLabel();
		this.add(label, BorderLayout.NORTH);
	}

	public void setLabel(String string) {
		label.setText(string);
	}

	public JComponent getComponent() {
		return component;
	}

}
