package ui.view.swing.util;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import org.joda.time.DateTime;
import org.joda.time.ReadableDateTime;

public class DateTimePicker extends Container {

	private JSpinner spinner;

	/**
	 * Constructs a date picker.
	 */
	public DateTimePicker() {
		setLayout(new BorderLayout());
		
		spinner = new JSpinner(new SpinnerDateModel());
		add(spinner);

		setDefaultFormat();
	}

	/**
	 * Constructs a date picker.
	 * @param simpleDateFormat Pattern as used in <code>SimpleDateFormat</code>.
	 */
	public DateTimePicker(String simpleDateFormat) {
		this();
		setFormat(simpleDateFormat);
	}

	public void setDefaultFormat() {
		JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner);
		spinner.setEditor(dateEditor);
	}

	/**
	 * Establishes the format.
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
	
}
