package ui.controller.initializer;

import query.QueryFactory;
import message.MessageId;
import ui.controller.action.Action;
import ui.controller.action.CloseDialogAction;
import ui.controller.action.ShowDialogAction;
import ui.controller.action.SearchAction;
import ui.view.component.StockArticlesUI;
import ui.view.swing.component.StockArticlesDialog;

public class StockDialogInitializer implements DialogInitializer {

	public StockArticlesUI dialog() {
		StockArticlesDialog dialog = new StockArticlesDialog();
		
		Action searchAction = new SearchAction(dialog.getSearchPanel(), QueryFactory.instance().stockArticleSearchQuery());
		dialog.getSearchPanel().setSearchAction(searchAction);
		searchAction.execute();
		
		Action showBuysDialogAction = new ShowDialogAction(new BuysDialogInitializer(), MessageId.buysDialogTitle);
		Action showStockDropDownsAction = new ShowDialogAction(new StockDropOutsDialogInitializer(), MessageId.stockDropDownsDialogTitle);

		dialog.setOkAction(new CloseDialogAction(dialog));
		dialog.setShowBuysAction(showBuysDialogAction);
		dialog.setShowStockDropDownsAction(showStockDropDownsAction);
		
		return dialog;
	}

}
