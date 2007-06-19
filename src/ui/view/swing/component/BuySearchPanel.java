package ui.view.swing.component;

import model.util.TimeUtils;

import org.joda.time.ReadableInterval;

import query.criteria.BuySearchCriteria;
import ui.view.swing.util.IntervalPicker;

public class BuySearchPanel extends StandardSearchPanel implements BuySearchCriteria {

	private IntervalPicker intervalPicker;

	public BuySearchPanel() {
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
