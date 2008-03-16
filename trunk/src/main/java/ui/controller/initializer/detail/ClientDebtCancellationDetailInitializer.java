package ui.controller.initializer.detail;

import ui.controller.manager.ClientManager;
import ui.controller.populator.ClientDebtCancellationPopulator;
import ui.view.component.DetailUI;
import ui.view.swing.component.detail.ClientDebtCancellationDialog;

public class ClientDebtCancellationDetailInitializer extends DetailDialogInitializer {
	
	public ClientDebtCancellationDetailInitializer() {
		super(new ClientDebtCancellationPopulator());
	}
	
	protected DetailUI baseDialog() {
		ClientDebtCancellationDialog dialog = new ClientDebtCancellationDialog();
		dialog.setClientManager(new ClientManager());
		return dialog;
	}
	
}
