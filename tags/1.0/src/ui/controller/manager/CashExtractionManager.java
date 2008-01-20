package ui.controller.manager;

import message.MessageId;
import ui.controller.initializer.search.CashExtractionsDialogInitializer;

public class CashExtractionManager extends StandardUIModelManager {

	public CashExtractionManager() {
		super(new CashExtractionsDialogInitializer(), store().cashBook().extractions(), MessageId.cashExtraction);
	}
	
}
