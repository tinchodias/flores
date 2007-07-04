/**
 * 
 */
package model;

import junit.framework.TestCase;
import model.money.Pesos;
import model.receipt.Sell;
import model.receipt.SellAnnulment;
import model.receipt.SellItems;
import model.stock.Article;

public class SellTest extends TestCase {

	private Store store;
	private Article clavel;
	private JuridicPerson elvira;
	private Sell sell;
	private JuridicPerson eduardo;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		store = StoreFixture.simpleStore();
		
		clavel = store.stockArticles().iterator().next();
		
		elvira = store.clients().iterator().next();
		
		eduardo = store.vendors().iterator().next();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testSimpleSellAndAnnulment() {
		
		Pesos initialDebt = store.debts().debtOf(elvira);
		double initialStock = store.stock().count(clavel);
		
		sell = StoreFixture.simpleSell(clavel, elvira, eduardo, store.stock().cost(clavel));
		store.add(sell);

		assertEquals(initialDebt.plus(Pesos.newFor(400.0)), store.debts().debtOf(elvira));
		assertEquals(initialStock - 100.0, store.stock().count(clavel));

		SellAnnulment annulment = StoreFixture.sellAnnulment(sell);
		store.add(annulment);
		
		assertEquals(initialDebt, store.debts().debtOf(elvira));
		assertEquals(initialStock, store.stock().count(clavel));
	}
	
	public void testAdjustSellTotal() {
		SellItems sellItems = new SellItems();
		sellItems.add(clavel, 20.0, Pesos.newFor(20.0), Pesos.newFor(10.0));

		Pesos adjustedTotal = Pesos.newFor(6.5);
		sellItems.adjustTotal(adjustedTotal);
		
		assertEquals(adjustedTotal, sellItems.sellTotal());
	}
	
}
