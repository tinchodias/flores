package ui.controller.action;

import message.MessageId;
import model.Store;
import model.Vendor;
import model.commission.CommissionSummary;
import persistence.ModelPersistence;
import security.Security;
import security.VendorProfile;
import ui.controller.initializer.detail.CommissionSummaryDetailInitializer;
import ui.controller.initializer.detail.mode.DetailMode;
import ui.view.component.CommissionCalculationUI;
import util.ValueHolder;

public class CalculateCommissionsAction implements Action {

	private final CommissionCalculationUI ui;

	public CalculateCommissionsAction(CommissionCalculationUI ui) {
		this.ui = ui;
	}

	public void execute() {
		show(summary());
	}

	private CommissionSummary summary() {
		Vendor vendor = ((VendorProfile) Security.instance().loggedUser().getProfile()).getVendor();
		Store store = ModelPersistence.instance().loadedModel().store();
		return store.commissions().commissionAt(vendor, ui.getInterval());
	}

	private void show(final CommissionSummary summary) {
		CommissionSummaryDetailInitializer initializer = new CommissionSummaryDetailInitializer();
		initializer.mode(DetailMode.VIEWING);
		initializer.objectHolder(new ValueHolder() {
			public Object getValue() {
				return summary;
			}
		});
		initializer.dialog().setVisible(true);
	}

	public MessageId messageId() {
		return MessageId.calculate;
	}

}
