/**
 * 
 */
package model.test;

import java.util.Date;

import junit.framework.TestCase;
import model.JuridicPerson;
import model.Store;
import model.debts.ClientDebtCancellation;
import model.debts.LostDebtDeclaration;
import model.money.Cash;
import model.money.Payment;
import model.money.Pesos;
import model.receipt.ArticleSpecification;
import model.receipt.Sell;
import model.stock.Article;

public class ClientsDebtsTest extends TestCase {

	private Store store;
	private Article clavel;
	private JuridicPerson elvira;
	
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

	public void testSimpleDebt() {
		doSell();
		
		assertEquals(Pesos.newFor(100.0), store.debts().debtOf(elvira));

		store.debts().add(new ClientDebtCancellation(elvira, Pesos.newFor(40.0), new Date()));
		assertEquals(Pesos.newFor(60.0), store.debts().debtOf(elvira));
		
		store.debts().add(new LostDebtDeclaration(elvira, Pesos.newFor(40.0), new Date()));
		assertEquals(Pesos.newFor(20.0), store.debts().debtOf(elvira));
	}

	private void doSell() {
		ArticleSpecification spec = new ArticleSpecification();
		spec.add(clavel, 10.0, Pesos.newFor(50.0));
		
		Payment payment = new Payment();
		payment.add(new Cash(Pesos.newFor(400.0)));
		
		Sell sell = new Sell(spec, new Date(), elvira, payment);
		store.add(sell);
	}
	
}
