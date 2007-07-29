package ui.controller.initializer.detail;

import ui.controller.initializer.search.CitiesDialogInitializer;
import ui.view.component.DetailUI;
import ui.view.swing.component.SupplierDialog;

public class SupplierDetailInitializer extends DetailDialogInitializer {

	protected DetailUI baseDialog() {
		SupplierDialog dialog = new SupplierDialog();

		dialog.getAddressUI().setCitySearchInitializer(new CitiesDialogInitializer());
		
		return dialog;
	}

}
