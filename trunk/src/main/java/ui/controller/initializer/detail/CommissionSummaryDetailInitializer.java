package ui.controller.initializer.detail;

import ui.controller.action.CreateCommissionCashExtraction;
import ui.controller.populator.CommissionSummaryPopulator;
import ui.view.component.DetailUI;
import ui.view.swing.component.detail.CommissionSummaryDialog;

public class CommissionSummaryDetailInitializer extends DetailDialogInitializer {

	public CommissionSummaryDetailInitializer() {
		super(new CommissionSummaryPopulator());
	}

	protected DetailUI baseDialog() {
		CommissionSummaryDialog dialog = new CommissionSummaryDialog();
		dialog.setAcceptAction(new CreateCommissionCashExtraction(dialog));
		
		return dialog;
	}

}
