package ui.controller.action;

import message.MessageId;
import model.JuridicPerson;
import model.Store;
import model.money.Cash;
import model.money.Payment;
import model.money.Pesos;
import model.receipt.Buy;
import model.receipt.BuyItem;
import model.receipt.BuyItems;

import org.joda.time.DateTime;

import persistence.ModelPersistence;
import query.framework.results.LazySearchResults;
import ui.view.component.BuyUI;

public class CreateBuyAction implements Action {

	private final BuyUI buyUI;

	public CreateBuyAction(BuyUI buyUI) {
		this.buyUI = buyUI;
	}
	
	public void execute() {
		Buy buy = buy();
		Store store = ModelPersistence.instance().loadedModel().store();
		store.add(buy);
		
		buyUI.setVisible(false);
	}

	private Buy buy() {
		return new Buy(buyItems(), new DateTime(), supplier(), payment());
	}

	private BuyItems buyItems() {
		LazySearchResults results = (LazySearchResults) buyUI.getItemsPanel().getResults();
		BuyItems items = new BuyItems();

		for (int i = 0; i < results.getRowCount(); i++) {
			items.add((BuyItem) results.get(i));
		}
		return items ;
	}

	private JuridicPerson supplier() {
		return buyUI.getSupplier();
	}

	private Payment payment() {
		Pesos cashPay = buyUI.getCashPay();

		Payment payment = new Payment();
		payment.add(new Cash(cashPay));
		
		return payment;
	}

	public MessageId messageId() {
		return MessageId.accept;
	}

}
