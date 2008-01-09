package ui.controller.manager;

import ui.controller.initializer.search.ClientsDialogInitializer;

public class ClientManager extends StandardUIModelManager {

	public ClientManager() {
		super(new ClientsDialogInitializer(), store().clients());
	}
	
}
