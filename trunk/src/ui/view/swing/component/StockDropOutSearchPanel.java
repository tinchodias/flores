package ui.view.swing.component;

import query.criteria.StockDropOutSearchCriteria;
import query.framework.criteria.Criteria;
import ui.controller.action.Action;

public class StockDropOutSearchPanel extends StandardSearchPanel implements StockDropOutSearchCriteria {

	public StockDropOutSearchPanel() {
	}

	public void setSearchAction(Action action) {
	}

	public Criteria criteria() {
		return this;
	}

}
