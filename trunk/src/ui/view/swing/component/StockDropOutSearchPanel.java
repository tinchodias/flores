package ui.view.swing.component;

import org.joda.time.ReadableInterval;

import model.util.TimeUtils;
import query.criteria.StockDropOutSearchCriteria;
import ui.controller.action.Action;
import ui.view.swing.util.IntervalPicker;

public class StockDropOutSearchPanel extends StandardSearchPanel implements StockDropOutSearchCriteria {

	private IntervalPicker picker;

	public StockDropOutSearchPanel() {
		initComponents();
	}

	private void initComponents() {
		picker = new IntervalPicker();
		picker.setInterval(TimeUtils.recentDaysInterval(14));
		
		filtersPanel().add(picker);		
	}

	public void setSearchAction(Action action) {
		//TODO add a "change listener" to the picker.. or think a more generic solution (i.e. in StandardSearchPanel).
	}

	public ReadableInterval getInterval() {
		return picker.getInterval();
	}

}
