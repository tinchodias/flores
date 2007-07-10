package ui.controller.initializer.detail;

import persistence.ModelPersistence;
import message.MessageId;
import model.Store;
import query.framework.results.SearchResults;
import query.framework.results.SellItemsLazySearchResults;
import ui.controller.action.RemoveSellItemAction;
import ui.controller.action.ShowDialogAction;
import ui.controller.initializer.AdjustSellTotalDialogInitializer;
import ui.controller.initializer.search.ClientsDialogInitializer;
import ui.view.component.DetailUI;
import ui.view.component.SellUI;
import ui.view.swing.component.SellDialog;

public class SellDetailInitializer extends DetailDialogInitializer {

	protected DetailUI baseDialog() {
		SellDialog sellDialog = new SellDialog();
		
		SearchResults results = new SellItemsLazySearchResults();
		sellDialog.getItemsPanel().setResults(results);
		
		sellDialog.getItemsPanel().add(new ShowDialogAction(new CreateSellItemDialogInitializer(sellDialog), MessageId.create));
		sellDialog.getItemsPanel().add(new RemoveSellItemAction(sellDialog));
		sellDialog.setClientSearchInitializer(new ClientsDialogInitializer());
		sellDialog.setAdjustTotalAction(new ShowDialogAction(new AdjustSellTotalDialogInitializer(sellDialog), MessageId.adjustTotal));
		
		return sellDialog;
	}

	@Override
	protected void initCreatingMode(DetailUI baseDialog) {
		super.initCreatingMode(baseDialog);
		
		//FIXME Hack for setting the "Final Consumer".
		
		SellUI sellUI = ((SellUI) baseDialog);

		Store store = ModelPersistence.instance().loadedModel().store();
		if (store.clients().size() > 0) {
			sellUI.setClient(store.clients().iterator().next());
		}
	}
	
}
