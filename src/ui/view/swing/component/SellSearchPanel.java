package ui.view.swing.component;

import model.util.TimeUtils;

import org.joda.time.ReadableInterval;

import query.criteria.SellSearchCriteria;
import ui.view.swing.util.IntervalPicker;

public class SellSearchPanel extends StandardSearchPanel implements SellSearchCriteria {

	private IntervalPicker intervalPicker;

	public SellSearchPanel() {
		initComponents();
	}

	private void initComponents() {
		intervalPicker = new IntervalPicker();
		intervalPicker.setInterval(TimeUtils.recentDaysInterval(14));
		
		filtersPanel().add(intervalPicker);		
	}

	public ReadableInterval getInterval() {
		return intervalPicker.getInterval();
	}

}
