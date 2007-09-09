package ui.controller.initializer.detail;

import ui.controller.populator.CashExtractionPopulator;
import ui.view.component.DetailUI;
import ui.view.swing.component.detail.CashExtractionDialog;

public class CashExtractionDetailInitializer extends DetailDialogInitializer {
	
	public CashExtractionDetailInitializer() {
		super(new CashExtractionPopulator());
	}
	
	protected DetailUI baseDialog() {
		return new CashExtractionDialog();
	}
	
}
