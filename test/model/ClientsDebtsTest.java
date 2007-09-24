/**
 * 
 */
package model;

import junit.framework.TestCase;
import model.money.Cash;
import model.money.Payment;
import model.money.MoneyAmount;
import model.receipt.Sell;
import model.receipt.SellItems;
import model.stock.Article;

import org.joda.time.DateTime;

public class ClientsDebtsTest extends TestCase {

	private Store store;
	private Article clavel;
	private JuridicPerson elvira;
	private Vendor eduardo;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		store = StoreFixture.simpleStore();
		
		clavel = store.stockArticles().iterator().next();
		
		elvira = store.clients().iterator().next();
		
		eduardo = store.vendors().iterator().next();
	}

	public void testSimpleDebt() {
		doSell();
		
		assertEquals(MoneyAmount.newFor(100.0), store.debts().debtOf(elvira));

		store.debts().add(StoreFixture.simpleClientDebtCancellation(elvira));
		assertEquals(MoneyAmount.newFor(60.0), store.debts().debtOf(elvira));
		
		store.debts().add(StoreFixture.simpleLostDebtDeclaration(elvira));
		assertEquals(MoneyAmount.newFor(20.0), store.debts().debtOf(elvira));
	}

	private void doSell() {
		SellItems spec = new SellItems();
		spec.add(clavel, 10.0, MoneyAmount.newFor(50.0), store.stock().cost(clavel));
		
		Payment payment = new Payment();
		payment.add(new Cash(MoneyAmount.newFor(400.0)));
		
		Sell sell = new Sell(spec, new DateTime(), elvira, payment, eduardo);
		store.add(sell);
	}
	
}
