/**
 * 
 */
package model.test;

import java.util.Date;

import junit.framework.TestCase;
import model.JuridicPerson;
import model.Store;
import model.money.Cash;
import model.money.Payment;
import model.money.Pesos;
import model.receipt.Sell;
import model.receipt.SellArticleSpecification;
import model.stock.Article;

public class ClientTest extends TestCase {

	private Store store;
	private Article clavel;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		store = TestsCommonFactory.makeEmptyStore();

		clavel = new Article("CL", "Paquete de Clavel");
		store.articles().add(clavel);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testAddClients() {
		assertEquals(0, store.clients().size());
		
		JuridicPerson elvira = new JuridicPerson("Elvira");
		JuridicPerson cuca = new JuridicPerson("Cuca");
		store.clients().add(elvira);
		store.clients().add(cuca);
		
		assertEquals(2, store.clients().size());
	}
	
	public void testInvalidRemove() {
		JuridicPerson elvira = new JuridicPerson("Elvira");
		JuridicPerson cuca = new JuridicPerson("Cuca");
		store.clients().add(elvira);
		store.clients().add(cuca);
		
		assertEquals(2, store.clients().size());
		
		doSellTo(elvira);

		try {
			store.clients().remove(cuca);
		} finally {
			assertEquals(1, store.clients().size());
		}

		try {
			store.clients().remove(elvira);
		} finally {
			assertEquals(1, store.clients().size());
		}
	}
	
	private void doSellTo(JuridicPerson client) {
		SellArticleSpecification spec = new SellArticleSpecification();
		spec.add(clavel, 100.0, Pesos.newFor(5.0), store.stock().cost(clavel));

		Payment payment = new Payment();
		payment.add(new Cash(Pesos.newFor(450.0)));
		
		Sell sell = new Sell(spec, new Date(), client, payment);
		store.add(sell);
	}
}
