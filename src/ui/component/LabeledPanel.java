package ui.component;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class LabeledPanel extends JPanel {

	private JLabel label;

	public LabeledPanel(JComponent component) {
		initPanel();
		add(component, BorderLayout.CENTER);
	}

	private void initPanel() {
		EmptyBorder emptyBorder = new EmptyBorder(0, 0, 0, 0);
		setBorder(emptyBorder);

		setLayout(new BorderLayout());
		
		label = new JLabel();
		this.add(label, BorderLayout.NORTH);
	}

	public void setTitle(String string) {
		label.setText(string);
	}

}
