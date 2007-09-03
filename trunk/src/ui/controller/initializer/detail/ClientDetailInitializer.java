package ui.controller.initializer.detail;

import ui.controller.initializer.search.CitiesDialogInitializer;
import ui.controller.populator.ClientPopulator;
import ui.view.component.DetailUI;
import ui.view.swing.component.detail.ClientDialog;

public class ClientDetailInitializer extends DetailDialogInitializer {

	public ClientDetailInitializer() {
		super(new ClientPopulator());
	}
	
	protected DetailUI baseDialog() {
		ClientDialog dialog = new ClientDialog();

		dialog.getAddressUI().setCitySearchInitializer(new CitiesDialogInitializer());
		
		return dialog;
	}

}
