package ui.controller.initializer.detail;

import message.MessageId;
import model.money.Pesos;
import query.framework.results.BuyItemsLazySearchResults;
import query.framework.results.SearchResults;
import ui.controller.action.RemoveBuyItemAction;
import ui.controller.action.ShowDialogAction;
import ui.controller.initializer.AdjustBuyTotalDialogInitializer;
import ui.controller.initializer.search.SuppliersDialogInitializer;
import ui.view.component.BuyUI;
import ui.view.component.DetailUI;
import ui.view.swing.component.BuyDialog;

public class BuyDetailInitializer extends DetailDialogInitializer {

	protected DetailUI baseDialog() {
		BuyDialog buyDialog = new BuyDialog();

		SearchResults results = new BuyItemsLazySearchResults();
		buyDialog.getItemsPanel().setResults(results);
		
		buyDialog.getItemsPanel().add(new ShowDialogAction(new CreateBuyItemDialogInitializer(buyDialog), MessageId.create));
		buyDialog.getItemsPanel().add(new RemoveBuyItemAction(buyDialog));
		buyDialog.setSupplierSearchInitializer(new SuppliersDialogInitializer());
		buyDialog.setAdjustTotalAction(new ShowDialogAction(new AdjustBuyTotalDialogInitializer(buyDialog), MessageId.adjustTotal));
		
		return buyDialog;
	}

	@Override
	protected void initCreatingMode(DetailUI baseDialog) {
		super.initCreatingMode(baseDialog);

		BuyUI buyUI = (BuyUI) baseDialog;

		buyUI.setCashPay(Pesos.newFor(0.0));
	}
}
