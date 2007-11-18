package ui.controller.manager;

import message.MessageId;
import ui.controller.initializer.search.ProvincesDialogInitializer;

public class ProvinceManager extends StandardUIModelManager {

	public ProvinceManager() {
		super(new ProvincesDialogInitializer(), store().provinces(), MessageId.province);
	}
	
}
