package ui.controller.manager;

import message.MessageId;
import ui.controller.initializer.search.CitiesDialogInitializer;

public class CityManager extends StandardUIModelManager {

	public CityManager() {
		super(new CitiesDialogInitializer(), store().cities(), MessageId.city);
	}
	
}
