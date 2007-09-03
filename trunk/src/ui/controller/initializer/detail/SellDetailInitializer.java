package ui.controller.initializer.detail;

import message.MessageId;
import model.Store;
import model.money.Pesos;
import persistence.ModelPersistence;
import query.framework.results.SearchResults;
import query.framework.results.SellItemsLazySearchResults;
import ui.controller.action.Action;
import ui.controller.action.CompositeAction;
import ui.controller.action.CreateAction;
import ui.controller.action.PrintSellReportAction;
import ui.controller.action.RemoveSellItemAction;
import ui.controller.action.ShowDialogAction;
import ui.controller.initializer.AdjustSellTotalDialogInitializer;
import ui.controller.initializer.search.ClientsDialogInitializer;
import ui.controller.populator.SellPopulator;
import ui.view.component.DetailUI;
import ui.view.component.SellUI;
import ui.view.swing.component.detail.SellDialog;
import util.ValueHolder;

public class SellDetailInitializer extends DetailDialogInitializer {

	public SellDetailInitializer() {
		super(new SellPopulator());
	}
	
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
		final CreateAction createAction = new CreateAction(baseDialog, populator());
		Action printAction = new PrintSellReportAction(new ValueHolder() {

			public Object getValue() {
				return createAction.getValue();
			}
			
		});
		CompositeAction createThenPrintAction = new CompositeAction(createAction, printAction, MessageId.acceptAndPrint);
		baseDialog.setAcceptAction(createThenPrintAction);
		
		//FIXME Hack for setting the "Final Consumer".
		SellUI sellUI = (SellUI) baseDialog;
		Store store = ModelPersistence.instance().loadedModel().store();
		if (store.clients().size() > 0) {
			sellUI.setClient(store.clients().iterator().next());
		}
		
		sellUI.setCashPay(Pesos.newFor(0.0));
	}
	
}
