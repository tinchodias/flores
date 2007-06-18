package ui.view.swing.util;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

import org.joda.time.ReadableInstant;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class ReadableInstantTableCellRenderer extends DefaultTableCellRenderer {

	private static ReadableInstantTableCellRenderer instance;
	private DateTimeFormatter formatter;

	public static ReadableInstantTableCellRenderer instance() {
		if (instance == null) {
			instance = new ReadableInstantTableCellRenderer();
		}
		return instance;
	}
	
	private ReadableInstantTableCellRenderer() {
		super();
		this.setHorizontalAlignment(JLabel.CENTER);
		formatter = DateTimeFormat.shortDateTime();
	}
	
	protected void setValue(Object value) {
		String text = "";
		
		if (value != null) {
			text = formatter.print((ReadableInstant) value);
		}
		setText(text);
	}
	
}
