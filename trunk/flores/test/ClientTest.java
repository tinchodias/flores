/**
 * 
 */
package model.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;
import model.Article;
import model.JuridicPerson;
import model.Store;
import model.money.Cash;
import model.money.Pay;
import model.money.Pesos;
import model.receipt.ArticleSpecification;
import model.receipt.Sell;

public class ClientTest extends TestCase {

	private Store depot;
	private Article paqueteClavel;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		depot = TestsCommonFactory.makeEmptyDepot();

		paqueteClavel = new Article("CL", "Paquete de Clavel");
		depot.articles().add(paqueteClavel);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testAddClients() {
		assertEquals(0, depot.clients().size());
		
		JuridicPerson elvira = new JuridicPerson("Elvira");
		JuridicPerson cuca = new JuridicPerson("Cuca");
		depot.clients().add(elvira);
		depot.clients().add(cuca);
		
		assertEquals(2, depot.clients().size());
	}
	
	public void testInvalidRemove() {
		JuridicPerson elvira = new JuridicPerson("Elvira");
		JuridicPerson cuca = new JuridicPerson("Cuca");
		depot.clients().add(elvira);
		depot.clients().add(cuca);
		
		assertEquals(2, depot.clients().size());
		
		doSellTo(elvira);

		try {
			depot.clients().remove(cuca);
		} finally {
			assertEquals(1, depot.clients().size());
		}

		try {
			depot.clients().remove(elvira);
		} finally {
			assertEquals(1, depot.clients().size());
		}
	}
	
	private void doSellTo(JuridicPerson client) {
		ArticleSpecification spec = new ArticleSpecification();
		spec.add(paqueteClavel, 100.0, Pesos.newFor(5.0));

		Set<Pay> payment = new HashSet<Pay>();
		payment.add(new Cash(Pesos.newFor(450.0)));
		
		Sell sell = new Sell(spec, new Date(), client, payment);
		depot.add(sell);
	}

	
}
