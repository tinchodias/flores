package ui.controller.manager;

import message.MessageId;
import ui.controller.initializer.search.ClientsDialogInitializer;

public class ClientManager extends StandardUIModelManager {

	public ClientManager() {
		super(new ClientsDialogInitializer(), store().clients(), MessageId.client);
	}
	
}
