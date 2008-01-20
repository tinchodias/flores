package ui.controller.initializer.detail;

import ui.controller.manager.ProvinceManager;
import ui.controller.populator.CityPopulator;
import ui.view.component.DetailUI;
import ui.view.swing.component.detail.CityDialog;

public class CityDetailInitializer extends DetailDialogInitializer {

	public CityDetailInitializer() {
		super(new CityPopulator());
	}
	
	protected DetailUI baseDialog() {
		CityDialog dialog = new CityDialog();
		dialog.setProvinceManager(new ProvinceManager());
		return dialog;
	}

}
