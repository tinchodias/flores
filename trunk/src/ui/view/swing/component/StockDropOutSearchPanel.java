package ui.view.swing.component;


import org.joda.time.ReadableInterval;

import query.criteria.StockDropOutSearchCriteria;
import ui.view.swing.util.IntervalPicker;
import util.TimeUtils;

public class StockDropOutSearchPanel extends StandardSearchPanel implements StockDropOutSearchCriteria {

	private IntervalPicker picker;

	public StockDropOutSearchPanel() {
		initComponents();
	}

	private void initComponents() {
		picker = new IntervalPicker();
		picker.setInterval(TimeUtils.recentYearsInterval(2));
		
		filtersPanel().add(picker);		
	}

	public ReadableInterval getInterval() {
		return picker.getInterval();
	}

}
