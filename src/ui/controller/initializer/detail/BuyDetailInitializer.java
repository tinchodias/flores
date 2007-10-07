package ui.controller.initializer.detail;

import message.MessageId;
import model.money.MoneyAmount;
import query.framework.results.BuyItemsLazySearchResults;
import query.framework.results.SearchResults;
import ui.controller.action.RemoveBuyItemAction;
import ui.controller.action.ShowDialogAction;
import ui.controller.initializer.AdjustBuyTotalDialogInitializer;
import ui.controller.manager.SupplierManager;
import ui.controller.populator.BuyPopulator;
import ui.view.component.BuyUI;
import ui.view.component.DetailUI;
import ui.view.swing.component.detail.BuyDialog;

public class BuyDetailInitializer extends DetailDialogInitializer {

	public BuyDetailInitializer() {
		super(new BuyPopulator());
	}
	
	protected DetailUI baseDialog() {
		BuyDialog buyDialog = new BuyDialog();

		SearchResults results = new BuyItemsLazySearchResults();
		buyDialog.getItemsPanel().setResults(results);
		
		buyDialog.getItemsPanel().add(new ShowDialogAction(new CreateBuyItemDialogInitializer(buyDialog), MessageId.create));
		buyDialog.getItemsPanel().add(new RemoveBuyItemAction(buyDialog));
		buyDialog.setSupplierManager(new SupplierManager());
		buyDialog.setAdjustTotalAction(new ShowDialogAction(new AdjustBuyTotalDialogInitializer(buyDialog), MessageId.adjustTotal));
		
		return buyDialog;
	}

	@Override
	protected void initCreatingMode(DetailUI baseDialog) {
		super.initCreatingMode(baseDialog);

		BuyUI buyUI = (BuyUI) baseDialog;

		buyUI.setCashPay(MoneyAmount.newFor(0.0));
	}
}
