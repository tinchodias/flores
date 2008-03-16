package ui.view.swing.component.search;

import org.joda.time.ReadableInterval;

import query.criteria.IntervalSearchCriteria;
import ui.view.component.IntervalSearchUI;
import ui.view.swing.SwingUI;
import ui.view.swing.util.IntervalPicker;
import util.TimeUtils;

public class IntervalSearchPanel extends StandardSearchPanel implements IntervalSearchUI, IntervalSearchCriteria {

	private IntervalPicker intervalPicker;

	public IntervalSearchPanel() {
		initComponents();
	}

	private void initComponents() {
		intervalPicker = new IntervalPicker();
		intervalPicker.setInterval(TimeUtils.recentYearsInterval(2));
		
		filtersPanel().add(SwingUI.instance().decorated(intervalPicker));		
	}

	public ReadableInterval getInterval() {
		return intervalPicker.getInterval();
	}

	public void setInterval(ReadableInterval interval) {
		intervalPicker.setInterval(interval);
	}

}
