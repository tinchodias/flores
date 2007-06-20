package ui.controller.initializer;

import message.MessageId;
import query.framework.results.LazySearchResults;
import query.framework.results.SearchResults;
import query.results.BuyItemResultsSpecification;
import ui.controller.action.CloseDialogAction;
import ui.controller.action.CreateBuyAction;
import ui.controller.action.RemoveBuyItemAction;
import ui.controller.action.ShowDialogAction;
import ui.view.component.DialogUI;
import ui.view.swing.component.BuyDialog;

public class CreateBuyDialogInitializer implements DialogInitializer {

	public DialogUI dialog() {
		BuyDialog buyDialog = new BuyDialog();
		
		//TODO re think this?
		SearchResults results = new LazySearchResults(new BuyItemResultsSpecification());
		buyDialog.getItemsPanel().setResults(results);
		
		buyDialog.getItemsPanel().add(new ShowDialogAction(new CreateBuyItemDialogInitializer(buyDialog), MessageId.create));
		buyDialog.getItemsPanel().add(new RemoveBuyItemAction(buyDialog));
		buyDialog.setSupplierSearchInitializer(new SuppliersDialogInitializer());

		buyDialog.setAcceptAction(new CreateBuyAction(buyDialog));
		buyDialog.setCancelAction(new CloseDialogAction(buyDialog));
		
		return buyDialog;
	}

}
