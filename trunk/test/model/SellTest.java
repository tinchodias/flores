/**
 * 
 */
package model;

import junit.framework.TestCase;
import model.money.MoneyAmount;
import model.receipt.Sell;
import model.receipt.SellCancellation;
import model.receipt.SellItems;
import model.stock.Article;

public class SellTest extends TestCase {

	private Store store;
	private Article clavel;
	private JuridicPerson elvira;
	private Sell sell;
	private Vendor eduardo;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		store = StoreFixture.simpleStore();
		
		clavel = store.stockArticles().iterator().next();
		
		elvira = store.clients().iterator().next();
		
		eduardo = store.vendors().iterator().next();
	}

	public void testSimpleSellAndCancellation() {
		
		MoneyAmount initialDebt = store.debts().debtOf(elvira);
		double initialStock = store.stock().count(clavel);
		
		sell = StoreFixture.simpleSell(clavel, elvira, eduardo, store.stock().cost(clavel));
		store.add(sell);

		assertEquals(initialDebt.plus(MoneyAmount.newFor(400.0)), store.debts().debtOf(elvira));
		assertEquals(initialStock - 100.0, store.stock().count(clavel));

		SellCancellation cancellation = StoreFixture.sellCancellation(sell);
		store.add(cancellation);
		
		assertEquals(initialDebt, store.debts().debtOf(elvira));
		assertEquals(initialStock, store.stock().count(clavel));
	}
	
	public void testAdjustSellTotal() {
		SellItems sellItems = new SellItems();
		sellItems.add(clavel, 20.0, MoneyAmount.newFor(20.0), MoneyAmount.newFor(10.0));

		MoneyAmount adjustedTotal = MoneyAmount.newFor(6.5);
		sellItems.adjustTotal(adjustedTotal);
		
		assertEquals(adjustedTotal, sellItems.sellTotal());
	}
	
}
