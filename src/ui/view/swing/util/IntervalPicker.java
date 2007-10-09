package ui.view.swing.util;

import java.awt.FlowLayout;

import javax.swing.JComponent;

import message.MessageId;

import org.joda.time.Interval;
import org.joda.time.ReadableInterval;

import ui.view.swing.SwingUI;

public class IntervalPicker extends JComponent {

	private DateTimePicker fromDate;
	private DateTimePicker toDate;

	public IntervalPicker() {
		fromDate = new DateTimePicker();
		toDate = new DateTimePicker();
		
		setLayout(new FlowLayout());
		add(SwingUI.instance().decorated(fromDate, MessageId.fromDate));
		add(SwingUI.instance().decorated(toDate, MessageId.toDate));
	}

	public ReadableInterval getInterval() {
		return new Interval(fromDate.getDateTime(), toDate.getDateTime());
	}
	
	public void setInterval(ReadableInterval interval) {
		fromDate.setDateTime(interval.getStart());
		toDate.setDateTime(interval.getEnd());
	}
	
}
