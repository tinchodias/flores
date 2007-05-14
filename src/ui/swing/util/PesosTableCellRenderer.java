package ui.swing.util;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

public class PesosTableCellRenderer extends DefaultTableCellRenderer {

	private static PesosTableCellRenderer instance;

	public static PesosTableCellRenderer instance() {
		if (instance == null) {
			instance = new PesosTableCellRenderer();
		}
		return instance;
	}
	
	private PesosTableCellRenderer() {
		super();
		this.setHorizontalAlignment(JLabel.RIGHT);
	}
}
