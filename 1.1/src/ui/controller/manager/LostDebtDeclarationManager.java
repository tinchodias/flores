package ui.controller.manager;

import message.MessageId;
import ui.controller.initializer.search.LostDebtDeclarationsDialogInitializer;

public class LostDebtDeclarationManager extends StandardUIModelManager {

	public LostDebtDeclarationManager() {
		super(new LostDebtDeclarationsDialogInitializer(), store().debts().declarations(), MessageId.lostDebtDeclaration);
	}
	
}
