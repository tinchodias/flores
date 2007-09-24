package ui.controller.populator;

import model.Store;
import model.money.Cash;
import model.money.Payment;
import model.money.MoneyAmount;
import model.receipt.Buy;
import model.receipt.BuyItems;

import org.joda.time.DateTime;

import persistence.ModelPersistence;
import query.framework.results.BuyItemsLazySearchResults;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import ui.view.component.BuyUI;

public class BuyPopulator implements DetailPopulator<Buy, BuyUI> {

	public Buy createFrom(BuyUI ui) {
		Buy buy = buy(ui);
		Store store = ModelPersistence.instance().loadedModel().store();
		store.add(buy);
		return buy;
	}

	public void modifyFrom(BuyUI ui, Buy object) {
		throw new NotImplementedException();
	}

	public void showIn(BuyUI ui, Buy object) {
		ui.setCashPay(object.payment().total());
		ui.setSupplier(object.supplier());
		ui.getItemsPanel().setResults(new BuyItemsLazySearchResults(object.items()));
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
		MoneyAmount cashPay = ui.getCashPay();

		Payment payment = new Payment();
		payment.add(new Cash(cashPay));
		
		return payment;
	}
	
}
