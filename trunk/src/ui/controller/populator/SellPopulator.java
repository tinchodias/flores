package ui.controller.populator;

import model.Store;
import model.Vendor;
import model.money.Cash;
import model.money.Payment;
import model.money.Pesos;
import model.receipt.Sell;
import model.receipt.SellItems;

import org.joda.time.DateTime;

import persistence.ModelPersistence;
import query.framework.results.SellItemsLazySearchResults;
import security.Security;
import security.VendorProfile;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import ui.view.component.SellUI;

public class SellPopulator implements DetailPopulator<Sell, SellUI> {

	public Sell createFrom(SellUI ui) {
		Sell sell = sell(ui);
		Store store = ModelPersistence.instance().loadedModel().store();
		store.add(sell);
		return sell;
	}

	public void modifyFrom(SellUI ui, Sell object) {
		throw new NotImplementedException();
	}

	public void showIn(SellUI ui, Sell object) {
		ui.setCashPay(object.payment().total());
		ui.setClient(object.client());
		ui.getItemsPanel().setResults(new SellItemsLazySearchResults(object.items()));
	}


	private Sell sell(SellUI ui) {
		return new Sell(sellItems(ui), new DateTime(), ui.getClient(), payment(ui), vendor());
	}

	private Vendor vendor() {
		return ((VendorProfile) Security.instance().loggedUser().getProfile()).getVendor();
	}

	private SellItems sellItems(SellUI ui) {
		SellItemsLazySearchResults results =
			(SellItemsLazySearchResults) ui.getItemsPanel().getResults();
		return results.getSellItems();
	}

	private Payment payment(SellUI ui) {
		Pesos cashPay = ui.getCashPay();

		Payment payment = new Payment();
		payment.add(new Cash(cashPay));
		
		return payment;
	}
	
}
