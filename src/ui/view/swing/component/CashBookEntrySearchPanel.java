package ui.view.swing.component;


import org.joda.time.ReadableInterval;

import query.criteria.CashBookEntrySearchCriteria;
import ui.view.swing.util.IntervalPicker;
import util.TimeUtils;

public class CashBookEntrySearchPanel extends StandardSearchPanel implements CashBookEntrySearchCriteria {

	private IntervalPicker intervalPicker;

	public CashBookEntrySearchPanel() {
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
