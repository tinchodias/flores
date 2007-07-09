package ui.controller.populator;

import model.JuridicPerson;
import model.Store;
import model.money.Cash;
import model.money.Payment;
import model.money.Pesos;
import model.receipt.Sell;
import model.receipt.SellItems;

import org.joda.time.DateTime;

import persistence.ModelPersistence;
import query.framework.results.SellItemsLazySearchResults;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import ui.view.component.SellUI;

public class SellPopulator extends DetailPopulator<Sell, SellUI> {

	public void createFrom(SellUI ui) {
		Sell sell = sell(ui);
		Store store = ModelPersistence.instance().loadedModel().store();
		store.add(sell);
	}

	public void modifyFrom(SellUI ui) {
		throw new NotImplementedException();
	}

	public void showIn(SellUI ui) {
		ui.setCashPay(getValue().payment().total());
		ui.setClient(getValue().client());
		ui.getItemsPanel().setResults(new SellItemsLazySearchResults(getValue().items()));
	}


	private Sell sell(SellUI ui) {
		return new Sell(sellItems(ui), new DateTime(), ui.getClient(), payment(ui), vendor());
	}

	private JuridicPerson vendor() {
		//TODO get current vendor!!
		return null;
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
