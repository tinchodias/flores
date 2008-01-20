package ui.controller.manager;

import message.MessageId;
import ui.controller.initializer.search.StockDialogInitializer;

public class StockManager extends StandardUIModelManager {

	public StockManager() {
		super(new StockDialogInitializer(), store().stockArticles(), MessageId.article);
	}
	
}
