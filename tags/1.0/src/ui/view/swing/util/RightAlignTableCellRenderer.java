package ui.view.swing.util;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

public class RightAlignTableCellRenderer extends DefaultTableCellRenderer {

	private static RightAlignTableCellRenderer instance;

	public static RightAlignTableCellRenderer instance() {
		if (instance == null) {
			instance = new RightAlignTableCellRenderer();
		}
		return instance;
	}
	
	private RightAlignTableCellRenderer() {
		super();
		this.setHorizontalAlignment(JLabel.RIGHT);
	}
}
