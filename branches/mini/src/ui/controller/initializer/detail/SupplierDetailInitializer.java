package ui.controller.initializer.detail;

import ui.controller.manager.CityManager;
import ui.controller.populator.SupplierPopulator;
import ui.view.component.DetailUI;
import ui.view.swing.component.detail.SupplierDialog;

public class SupplierDetailInitializer extends DetailDialogInitializer {

	public SupplierDetailInitializer() {
		super(new SupplierPopulator());
	}
	
	protected DetailUI baseDialog() {
		SupplierDialog dialog = new SupplierDialog();
		dialog.getAddressUI().setCityManager(new CityManager());
		return dialog;
	}

}
