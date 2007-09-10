/**
 * 
 */
package model;

import junit.framework.TestCase;
import model.stock.Article;

public class ClientTest extends TestCase {

	private Store store;
	private Article clavel;
	private Vendor eduardo;

	protected void setUp() throws Exception {
		super.setUp();
		
		store = StoreFixture.emptyStore();

		clavel = new Article("Paquete de Clavel");
		store.stockArticles().add(clavel);

		eduardo = new Vendor("Eduardo");
		store.vendors().add(eduardo);
	}

	public void testAddClients() {
		assertEquals(0, store.clients().size());
		
		JuridicPerson elvira = new JuridicPerson("Elvira");
		JuridicPerson cuca = new JuridicPerson("Cuca");
		store.clients().add(elvira);
		store.clients().add(cuca);
		
		assertEquals(2, store.clients().size());
	}
	
//TODO Uncomment this
//	public void testInvalidRemove() {
//		JuridicPerson elvira = new JuridicPerson("Elvira");
//		JuridicPerson cuca = new JuridicPerson("Cuca");
//		store.clients().add(elvira);
//		store.clients().add(cuca);
//		
//		assertEquals(2, store.clients().size());
//		
//		doSellTo(elvira);
//
//		try {
//			store.clients().remove(cuca);
//		} finally {
//			assertEquals(1, store.clients().size());
//		}
//
//		try {
//			store.clients().remove(elvira);
//		} finally {
//			assertEquals(1, store.clients().size());
//		}
//	}
//	
//	private void doSellTo(JuridicPerson client) {
//		SellItems spec = new SellItems();
//		spec.add(clavel, 100.0, Pesos.newFor(5.0), store.stock().cost(clavel));
//
//		Payment payment = new Payment();
//		payment.add(new Cash(Pesos.newFor(450.0)));
//		
//		Sell sell = new Sell(spec, new DateTime(), client, payment, eduardo);
//		store.add(sell);
//	}
}
