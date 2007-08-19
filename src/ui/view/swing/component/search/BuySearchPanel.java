package ui.view.swing.component.search;


import org.joda.time.ReadableInterval;

import query.criteria.BuySearchCriteria;
import ui.view.swing.util.IntervalPicker;
import util.TimeUtils;

public class BuySearchPanel extends StandardSearchPanel implements BuySearchCriteria {

	private IntervalPicker intervalPicker;

	public BuySearchPanel() {
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
