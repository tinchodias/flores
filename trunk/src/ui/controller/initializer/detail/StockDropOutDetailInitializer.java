package ui.controller.initializer.detail;

import ui.controller.initializer.search.StockDialogInitializer;
import ui.controller.populator.StockDropOutPopulator;
import ui.view.component.DetailUI;
import ui.view.swing.component.detail.StockDropOutDialog;

public class StockDropOutDetailInitializer extends DetailDialogInitializer {
	
	public StockDropOutDetailInitializer() {
		super(new StockDropOutPopulator());
	}
	
	protected DetailUI baseDialog() {
		StockDropOutDialog dialog = new StockDropOutDialog();
		
		dialog.setArticleSearchInitializer(new StockDialogInitializer());
		
		return dialog;
	}
	
}
