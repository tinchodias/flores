package ui.view.swing.util;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import org.joda.time.DateTime;
import org.joda.time.ReadableDateTime;

public class DateTimePicker extends JComponent {

	public static final String DEFAULT_FORMAT = "dd/MM/yy";
	private JSpinner spinner;

	/**
	 * Constructs a date picker with default format.
	 */
	public DateTimePicker() {
		this(DEFAULT_FORMAT);
	}

	/**
	 * Constructs a date picker.
	 * @param simpleDateFormat Pattern as used in <code>SimpleDateFormat</code>.
	 */
	public DateTimePicker(String simpleDateFormat) {
		setLayout(new BorderLayout());
		
		spinner = new JSpinner(new SpinnerDateModel());
		add(spinner);
		
		setFormat(simpleDateFormat);
	}

	public void setDefaultFormat() {
		JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner);
		spinner.setEditor(dateEditor);
	}

	/**
	 * Establishes the format.
	 * Note: It creates a new editor.
	 * @param simpleDateFormat Pattern as used in <code>SimpleDateFormat</code>.
	 */
	public void setFormat(String simpleDateFormat) {
		JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner, simpleDateFormat);
		spinner.setEditor(dateEditor);
	}
	
	public void setDateTime(ReadableDateTime date) {
		spinner.setValue(date.toDateTime().toDate());
	}
	
	public ReadableDateTime getDateTime() {
		return new DateTime(spinner.getValue());
	}

	public JSpinner.DateEditor getEditor() {
		return (JSpinner.DateEditor) spinner.getEditor();
	}
	
}
