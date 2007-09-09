package ui.view.swing.component.search;

import org.joda.time.ReadableInterval;

import query.criteria.IntervalSearchCriteria;
import ui.view.swing.util.IntervalPicker;
import util.TimeUtils;

public class IntervalSearchPanel extends StandardSearchPanel implements IntervalSearchCriteria {

	private IntervalPicker intervalPicker;

	public IntervalSearchPanel() {
		initComponents();
	}

	private void initComponents() {
		intervalPicker = new IntervalPicker();
		intervalPicker.setInterval(TimeUtils.recentYearsInterval(2));
		
		filtersPanel().add(intervalPicker);		
	}

	public ReadableInterval getInterval() {
		return intervalPicker.getInterval();
	}

}
