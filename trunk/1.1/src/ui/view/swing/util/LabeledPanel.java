package ui.view.swing.util;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class LabeledPanel extends JPanel {

	private JLabel label;
	private final Component component;

	public LabeledPanel(Component component, String label, Border border) {
		this.component = component;

		setBorder(border);
		setLayout(new BorderLayout());
		
		this.label = new JLabel(label);
		Dimension size = this.label.getPreferredSize();
		size.height += 8;
		this.label.setLabelFor(component);
		this.label.setPreferredSize(size);
		this.label.setVerticalAlignment(SwingConstants.BOTTOM);
		
		this.add(this.label, BorderLayout.NORTH);
		add(component, BorderLayout.CENTER);
	}

	public LabeledPanel(Component component, String label) {
		this(component, label, null);
	}
	
	public void setLabel(String string) {
		label.setText(string);
	}

	public Component getComponent() {
		return component;
	}

}
