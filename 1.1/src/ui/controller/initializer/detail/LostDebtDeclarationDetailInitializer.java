package ui.controller.initializer.detail;

import ui.controller.manager.ClientManager;
import ui.controller.populator.LostDebtDeclarationPopulator;
import ui.view.component.DetailUI;
import ui.view.swing.component.detail.LostDebtDeclarationDialog;

public class LostDebtDeclarationDetailInitializer extends DetailDialogInitializer {
	
	public LostDebtDeclarationDetailInitializer() {
		super(new LostDebtDeclarationPopulator());
	}
	
	protected DetailUI baseDialog() {
		LostDebtDeclarationDialog dialog = new LostDebtDeclarationDialog();
		dialog.setClientManager(new ClientManager());
		return dialog;
	}
	
}
