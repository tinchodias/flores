/**
 * 
 */
package model.test;

import java.util.Date;

import junit.framework.TestCase;
import model.Article;
import model.JuridicPerson;
import model.Store;
import model.money.Payment;
import model.money.Pesos;
import model.receipt.ArticleSpecification;
import model.receipt.Buy;
import model.receipt.BuyAnnulment;

public class BuyTest extends TestCase {

	private Store depot;
	private Article rosas;
	private Article claveles;
	private JuridicPerson marquez;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		depot = TestsCommonFactory.makeEmptyStore();

		marquez = new JuridicPerson("Marquez");
		depot.clients().add(marquez);
		
		rosas = new Article("RO40", "Paquete de Rosa x 40");
		claveles = new Article("CL", "Paquete de Clavel");
		depot.articles().add(claveles);
		depot.articles().add(rosas);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testBuyAndAnnulment() {
		Buy buy1 = createBuy1();
		depot.add(buy1);
		
		assertEquals(20.0, depot.stock().count(claveles));
		assertEquals(10.0, depot.stock().count(rosas));

		Buy buy2 = createBuy2();
		depot.add(buy2);
		
		assertEquals(120.0, depot.stock().count(claveles));
		assertEquals(210.0, depot.stock().count(rosas));
		
		BuyAnnulment buy1Annulment = createBuyAnnulment(buy1);
		depot.add(buy1Annulment);

		assertEquals(100.0, depot.stock().count(claveles));
		assertEquals(200.0, depot.stock().count(rosas));
		
		BuyAnnulment buy2Annulment = createBuyAnnulment(buy2);
		depot.add(buy2Annulment);

		assertEquals(0.0, depot.stock().count(claveles));
		assertEquals(0.0, depot.stock().count(rosas));
	}

	private BuyAnnulment createBuyAnnulment(Buy buy) {
		return new BuyAnnulment(buy, new Date());
	}

	private Buy createBuy1() {
		ArticleSpecification spec = new ArticleSpecification();
		spec.add(claveles, 20.0, Pesos.newFor(20.0));
		spec.add(rosas, 10.0, Pesos.newFor(15.0));

		return new Buy(spec, new Date(), marquez, new Payment());
	}
	
	private Buy createBuy2() {
		ArticleSpecification spec = new ArticleSpecification();
		spec.add(claveles, 100.0, Pesos.newFor(20.0));
		spec.add(rosas, 200.0, Pesos.newFor(15.0));

		return new Buy(spec, new Date(), marquez, new Payment());
	}
}
