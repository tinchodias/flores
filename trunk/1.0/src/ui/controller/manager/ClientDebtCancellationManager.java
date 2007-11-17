package ui.controller.manager;

import message.MessageId;
import ui.controller.initializer.search.ClientDebtCancellationsDialogInitializer;


public class ClientDebtCancellationManager extends StandardUIModelManager {

	public ClientDebtCancellationManager() {
		super(new ClientDebtCancellationsDialogInitializer(), store().debts().cancellations(), MessageId.clientDebtCancellation);
	}
	
}
