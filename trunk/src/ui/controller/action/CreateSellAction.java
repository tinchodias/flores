package ui.controller.action;

import message.MessageId;
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
import ui.view.component.SellUI;

public class CreateSellAction implements Action {

	private final SellUI sellUI;

	public CreateSellAction(SellUI sellUI) {
		this.sellUI = sellUI;
	}
	
	public void execute() {
		Sell sell = sell();
		Store store = ModelPersistence.instance().loadedModel().store();
		store.add(sell);
		
		sellUI.setVisible(false);
	}

	private Sell sell() {
		return new Sell(sellItems(), new DateTime(), client(), payment(), vendor());
	}

	private JuridicPerson vendor() {
		//TODO get current vendor!!
		return null;
	}

	private SellItems sellItems() {
		SellItemsLazySearchResults results = 
			(SellItemsLazySearchResults) sellUI.getItemsPanel().getResults();
		return results.getSellItems();
	}

	private JuridicPerson client() {
		return sellUI.getClient();
	}

	private Payment payment() {
		Pesos cashPay = sellUI.getCashPay();

		Payment payment = new Payment();
		payment.add(new Cash(cashPay));
		
		return payment;
	}

	public MessageId messageId() {
		return MessageId.accept;
	}

}
