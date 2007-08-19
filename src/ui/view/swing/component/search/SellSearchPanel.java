package ui.view.swing.component.search;


import org.joda.time.ReadableInterval;

import query.criteria.SellSearchCriteria;
import ui.view.swing.util.IntervalPicker;
import util.TimeUtils;

public class SellSearchPanel extends StandardSearchPanel implements SellSearchCriteria {

	private IntervalPicker intervalPicker;

	public SellSearchPanel() {
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
