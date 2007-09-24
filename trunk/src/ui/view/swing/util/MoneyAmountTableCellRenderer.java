package ui.view.swing.util;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

public class MoneyAmountTableCellRenderer extends DefaultTableCellRenderer {

	private static MoneyAmountTableCellRenderer instance;

	public static MoneyAmountTableCellRenderer instance() {
		if (instance == null) {
			instance = new MoneyAmountTableCellRenderer();
		}
		return instance;
	}
	
	private MoneyAmountTableCellRenderer() {
		super();
		this.setHorizontalAlignment(JLabel.RIGHT);
	}
}
