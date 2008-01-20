package ui.controller.initializer.detail;

import ui.controller.manager.StockManager;
import ui.controller.populator.StockDropOutPopulator;
import ui.view.component.DetailUI;
import ui.view.swing.component.detail.StockDropOutDialog;

public class StockDropOutDetailInitializer extends DetailDialogInitializer {
	
	public StockDropOutDetailInitializer() {
		super(new StockDropOutPopulator());
	}
	
	protected DetailUI baseDialog() {
		StockDropOutDialog dialog = new StockDropOutDialog();
		dialog.setArticleManager(new StockManager());
		return dialog;
	}
	
}
