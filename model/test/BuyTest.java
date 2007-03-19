/**
 * 
 */
package model.test;

import java.util.Date;

import junit.framework.TestCase;
import model.JuridicPerson;
import model.Store;
import model.money.Payment;
import model.money.Pesos;
import model.receipt.BuyArticleSpecification;
import model.receipt.Buy;
import model.receipt.BuyAnnulment;
import model.stock.Article;

public class BuyTest extends TestCase {

	private Store store;
	private Article rosas;
	private Article claveles;
	private JuridicPerson marquez;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		store = TestsCommonFactory.makeEmptyStore();

		marquez = new JuridicPerson("Marquez");
		store.clients().add(marquez);
		
		rosas = new Article("RO40", "Paquete de Rosa x 40");
		claveles = new Article("CL", "Paquete de Clavel");
		store.articles().add(claveles);
		store.articles().add(rosas);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testBuyAndAnnulment() {
		Buy buy1 = createBuy1();
		store.add(buy1);
		
		assertEquals(20.0, store.stock().count(claveles));
		assertEquals(10.0, store.stock().count(rosas));

		Buy buy2 = createBuy2();
		store.add(buy2);
		
		assertEquals(120.0, store.stock().count(claveles));
		assertEquals(210.0, store.stock().count(rosas));
		
		BuyAnnulment buy1Annulment = createBuyAnnulment(buy1);
		store.add(buy1Annulment);

		assertEquals(100.0, store.stock().count(claveles));
		assertEquals(200.0, store.stock().count(rosas));
		
		BuyAnnulment buy2Annulment = createBuyAnnulment(buy2);
		store.add(buy2Annulment);

		assertEquals(0.0, store.stock().count(claveles));
		assertEquals(0.0, store.stock().count(rosas));
	}

	private BuyAnnulment createBuyAnnulment(Buy buy) {
		return new BuyAnnulment(buy, new Date());
	}

	private Buy createBuy1() {
		BuyArticleSpecification spec = new BuyArticleSpecification();
		spec.add(claveles, 20.0, Pesos.newFor(20.0));
		spec.add(rosas, 10.0, Pesos.newFor(15.0));

		return new Buy(spec, new Date(), marquez, new Payment());
	}
	
	private Buy createBuy2() {
		BuyArticleSpecification spec = new BuyArticleSpecification();
		spec.add(claveles, 100.0, Pesos.newFor(20.0));
		spec.add(rosas, 200.0, Pesos.newFor(15.0));

		return new Buy(spec, new Date(), marquez, new Payment());
	}
}
