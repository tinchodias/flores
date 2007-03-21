/**
 * 
 */
package model.test;

import java.util.Date;

import junit.framework.TestCase;
import model.JuridicPerson;
import model.Store;
import model.commission.CommissionSummary;
import model.money.Cash;
import model.money.Payment;
import model.money.Pesos;
import model.receipt.Sell;
import model.receipt.SellArticleSpecification;
import model.stock.Article;
import model.util.TimeUtils;

public class CommissionTest extends TestCase {

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
		
		store = TestsCommonFactory.makeSimpleStore();
		
		clavel = store.productArticles().iterator().next();
		
		elvira = store.clients().iterator().next();
		
		eduardo = store.vendors().iterator().next();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testSimpleCommissions() {
		CommissionSummary summary0 = store.commissions().commissionAt(eduardo, TimeUtils.todayInterval());
		assertEquals(Pesos.newFor(0.0), summary0.getTotal());
		
		doSell();

		CommissionSummary summary1 = store.commissions().commissionAt(eduardo, TimeUtils.todayInterval());
		assertTrue(summary1.getTotal().value() > 0.0);
	}

	/**
	 * Elvira buys 100 claveles at $9 each, paying $500. 
	 */
	private void doSell() {
		SellArticleSpecification spec = new SellArticleSpecification();
		spec.add(clavel, 100.0, Pesos.newFor(9.0), store.stock().cost(clavel));
		
		Payment payment = new Payment();
		payment.add(new Cash(Pesos.newFor(500.0)));
		
		sell = new Sell(spec, new Date(), elvira, payment);
		store.add(sell);
	}
}
