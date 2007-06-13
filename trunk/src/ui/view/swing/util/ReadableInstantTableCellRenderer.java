package ui.view.swing.util;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

import org.joda.time.DateTime;
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
			
			//TODO joda-time has persitence problems!! this is only a temporal fix!
//			ReadableInstant readableInstant = (ReadableInstant) value;
//			DateTime dateTime = new DateTime(readableInstant.getMillis());
//			text = formatter.print(dateTime);

//			DateFormat formatter2 = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
//			text = formatter2.format(((ReadableDateTime) value).toDateTime().toDate());
		}
		setText(text);
	}
	
}
