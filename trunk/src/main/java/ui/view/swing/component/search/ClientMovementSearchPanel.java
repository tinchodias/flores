package ui.view.swing.component.search;

import model.JuridicPerson;

import org.joda.time.ReadableInterval;

import query.framework.criteria.ClientMovementSearchCriteria;
import ui.view.swing.SwingUI;
import ui.view.swing.util.IntervalPicker;
import util.TimeUtils;
import util.ValueHolder;

public class ClientMovementSearchPanel extends StandardSearchPanel implements ClientMovementSearchCriteria {

	private IntervalPicker intervalPicker;
	private final ValueHolder clientHolder;

	public ClientMovementSearchPanel(ValueHolder clientHolder) {
		this.clientHolder = clientHolder;
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

	public JuridicPerson getClient() {
		return (JuridicPerson) clientHolder.getValue();
	}

}
