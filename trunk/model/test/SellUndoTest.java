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
import model.receipt.SellCancellation;

public class SellUndoTest extends TestCase {

	private Store store;
	private Article article1;
	private Article article2;
	private JuridicPerson elvira;
	private Sell sell;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		store = TestsCommonFactory.makeSimpleStore();
		
		Iterator<Article> iterator = store.articles().iterator();
		article1 = iterator.next();
		article2 = iterator.next();
		
		elvira = store.clients().iterator().next();
		
		doSell();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void doSell() {
		ArticleSpecification spec = new ArticleSpecification();
		spec.add(article1, 100.0, Pesos.newFor(9.0));
		
		Payment payment = new Payment();
		payment.add(new Cash(Pesos.newFor(500.0)));
		
		sell = new Sell(spec, new Date(), elvira, payment);
		store.add(sell);
	}
	
	public void testUndoSell() {
		assertEquals(Pesos.newFor(400.0), store.debts().debtOf(elvira));
		
		new SellCancellation(sell, new Date());
	}
}
