package ui.controller.manager;

import message.MessageId;
import ui.controller.initializer.search.BuysDialogInitializer;

public class BuyManager extends StandardUIModelManager {

	public BuyManager() {
		super(new BuysDialogInitializer(), store().buys(), MessageId.buy);
	}
	
}
