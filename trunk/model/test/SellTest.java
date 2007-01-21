/**
 * 
 */
package model.test;

import java.util.Date;
import java.util.Iterator;

import junit.framework.TestCase;
import model.Article;
import model.JuridicPerson;
import model.Store;
import model.money.Cash;
import model.money.Check;
import model.money.Payment;
import model.money.Pesos;
import model.receipt.ArticleSpecification;
import model.receipt.Buy;
import model.receipt.Sell;
import model.receipt.SellAnnulment;

public class SellTest extends TestCase {

	private Store store;
	private Article clavel;
	private JuridicPerson elvira;
	private Sell sell;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		store = TestsCommonFactory.makeSimpleStore();
		
		clavel = store.articles().iterator().next();
		
		elvira = store.clients().iterator().next();
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
		
		doSell();

		assertEquals(initialDebt.plus(Pesos.newFor(400.0)), store.debts().debtOf(elvira));
		assertEquals(initialStock - 100.0, store.stock().count(clavel));
		
		doAnnulment();
		
		assertEquals(initialDebt, store.debts().debtOf(elvira));
		assertEquals(initialStock, store.stock().count(clavel));
	}

	/**
	 * Elvira buys 100 claveles at $9 each, paying $500. 
	 */
	private void doSell() {
		ArticleSpecification spec = new ArticleSpecification();
		spec.add(clavel, 100.0, Pesos.newFor(9.0));
		
		Payment payment = new Payment();
		payment.add(new Cash(Pesos.newFor(500.0)));
		
		sell = new Sell(spec, new Date(), elvira, payment);
		store.add(sell);
	}
	
	/**
	 * Makes the annulment of the sell.
	 */
	private void doAnnulment() {
		SellAnnulment annulment = new SellAnnulment(sell, new Date());
		
		store.add(annulment);
	}
}
