package ui.controller.populator;

import model.commission.CommissionSummary;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import ui.view.component.CommissionSummaryUI;

public class CommissionSummaryPopulator implements DetailPopulator<CommissionSummary, CommissionSummaryUI> {

	public CommissionSummary createFrom(CommissionSummaryUI ui) {
		throw new NotImplementedException();
	}
	
	public void modifyFrom(CommissionSummaryUI ui, CommissionSummary object) {
		throw new NotImplementedException();
	}
	
	public void showIn(CommissionSummaryUI ui, CommissionSummary object) {
		ui.setCostTotal(object.getCostTotal());
		ui.setExpensesTotal(object.getExpensesTotal());
		ui.setSellTotal(object.getSellTotal());
		ui.setTotal(object.getTotal());
		ui.setInterval(object.getInterval());
		ui.setVendor(object.getVendor());
	}

}
