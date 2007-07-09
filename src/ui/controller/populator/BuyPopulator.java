package ui.controller.populator;

import model.Store;
import model.money.Cash;
import model.money.Payment;
import model.money.Pesos;
import model.receipt.Buy;
import model.receipt.BuyItems;

import org.joda.time.DateTime;

import persistence.ModelPersistence;
import query.framework.results.BuyItemsLazySearchResults;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import ui.view.component.BuyUI;

public class BuyPopulator extends DetailPopulator<Buy, BuyUI> {

	public void createFrom(BuyUI ui) {
		Buy buy = buy(ui);
		Store store = ModelPersistence.instance().loadedModel().store();
		store.add(buy);
	}

	public void modifyFrom(BuyUI ui) {
		throw new NotImplementedException();
	}

	public void showIn(BuyUI ui) {
		ui.setCashPay(getValue().payment().total());
		ui.setSupplier(getValue().supplier());
		ui.getItemsPanel().setResults(new BuyItemsLazySearchResults(getValue().items()));
	}

	private Buy buy(BuyUI ui) {
		return new Buy(buyItems(ui), new DateTime(), ui.getSupplier(), payment(ui));
	}

	private BuyItems buyItems(BuyUI ui) {
		BuyItemsLazySearchResults results = 
			(BuyItemsLazySearchResults) ui.getItemsPanel().getResults();
		return results.getBuyItems();
	}

	private Payment payment(BuyUI ui) {
		Pesos cashPay = ui.getCashPay();

		Payment payment = new Payment();
		payment.add(new Cash(cashPay));
		
		return payment;
	}
	
}
