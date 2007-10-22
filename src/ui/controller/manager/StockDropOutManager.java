package ui.controller.manager;

import message.MessageId;
import ui.controller.initializer.search.StockDropOutsDialogInitializer;

public class StockDropOutManager extends StandardUIModelManager {

	public StockDropOutManager() {
		super(new StockDropOutsDialogInitializer(), store().stock().dropOuts(), MessageId.stockDropOut);
	}
	
}
