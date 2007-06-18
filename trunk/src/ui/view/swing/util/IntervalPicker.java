package ui.view.swing.util;

import java.awt.Container;
import java.awt.FlowLayout;

import message.MessageId;

import org.joda.time.Interval;
import org.joda.time.ReadableInterval;

import ui.view.swing.SwingUI;

public class IntervalPicker extends Container {

	private static final String DEFAULT_FORMAT = "dd/MM/yy";
	private DateTimePicker fromDate;
	private DateTimePicker toDate;

	public IntervalPicker() {
		setLayout(new FlowLayout());

		fromDate = new DateTimePicker();
		toDate = new DateTimePicker();
		
		add(SwingUI.instance().label(fromDate, MessageId.fromDate));
		add(SwingUI.instance().label(toDate, MessageId.toDate));
		
		setFormat(DEFAULT_FORMAT);
	}

	/**
	 * @see DateTimePicker#setFormat(String)
	 */
	private void setFormat(String simpleDateFormat) {
		fromDate.setFormat(simpleDateFormat);
		toDate.setFormat(simpleDateFormat);
	}

	public ReadableInterval getInterval() {
		return new Interval(fromDate.getDateTime(), toDate.getDateTime());
	}
	
	public void setInterval(ReadableInterval interval) {
		fromDate.setDateTime(interval.getStart());
		toDate.setDateTime(interval.getEnd());
	}
	
}
