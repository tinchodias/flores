package ui.controller.manager;

import ui.controller.initializer.search.CitiesDialogInitializer;

public class CityManager extends StandardUIModelManager {

	public CityManager() {
		super(new CitiesDialogInitializer(), store().cities());
	}
	
}
