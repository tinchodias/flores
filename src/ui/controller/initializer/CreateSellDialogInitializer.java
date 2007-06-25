package ui.controller.initializer;

import message.MessageId;
import query.framework.results.SearchResults;
import query.framework.results.SellItemsLazySearchResults;
import ui.controller.action.CloseDialogAction;
import ui.controller.action.CreateSellAction;
import ui.controller.action.RemoveSellItemAction;
import ui.controller.action.ShowDialogAction;
import ui.view.component.DialogUI;
import ui.view.swing.component.SellDialog;

public class CreateSellDialogInitializer implements DialogInitializer {

	public DialogUI dialog() {
		SellDialog sellDialog = new SellDialog();
		
		SearchResults results = new SellItemsLazySearchResults();
		sellDialog.getItemsPanel().setResults(results);
		
		sellDialog.getItemsPanel().add(new ShowDialogAction(new CreateSellItemDialogInitializer(sellDialog), MessageId.create));
		sellDialog.getItemsPanel().add(new RemoveSellItemAction(sellDialog));
		sellDialog.setClientSearchInitializer(new ClientsDialogInitializer());
		sellDialog.setAdjustTotalAction(new ShowDialogAction(new AdjustSellTotalDialogInitializer(sellDialog), MessageId.adjustTotal));
		
		sellDialog.setAcceptAction(new CreateSellAction(sellDialog));
		sellDialog.setCancelAction(new CloseDialogAction(sellDialog));
		
		return sellDialog;
	}

}
