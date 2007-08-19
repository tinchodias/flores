package ui.view.swing.component.search;

import org.joda.time.ReadableInterval;

import query.criteria.ExpenseSearchCriteria;
import ui.view.swing.util.IntervalPicker;
import util.TimeUtils;

public class ExpenseSearchPanel extends StandardSearchPanel implements ExpenseSearchCriteria {

	private IntervalPicker intervalPicker;

	public ExpenseSearchPanel() {
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
