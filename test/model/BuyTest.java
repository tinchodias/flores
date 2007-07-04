/**
 * 
 */
package model;

import junit.framework.TestCase;
import model.JuridicPerson;
import model.Store;
import model.money.Payment;
import model.money.Pesos;
import model.receipt.Buy;
import model.receipt.BuyAnnulment;
import model.receipt.BuyItems;
import model.stock.Article;

import org.joda.time.DateTime;

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
		
		store = StoreFixture.emptyStore();

		marquez = new JuridicPerson("Marquez");
		store.clients().add(marquez);
		
		rosas = new Article("Paquete de Rosa x 40");
		claveles = new Article("Paquete de Clavel");
		store.stockArticles().add(claveles);
		store.stockArticles().add(rosas);
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
		return new BuyAnnulment(buy, new DateTime());
	}

	private Buy createBuy1() {
		BuyItems spec = new BuyItems();
		spec.add(claveles, 20.0, Pesos.newFor(20.0));
		spec.add(rosas, 10.0, Pesos.newFor(15.0));

		return new Buy(spec, new DateTime(), marquez, new Payment());
	}
	
	private Buy createBuy2() {
		BuyItems spec = new BuyItems();
		spec.add(claveles, 100.0, Pesos.newFor(20.0));
		spec.add(rosas, 200.0, Pesos.newFor(15.0));

		return new Buy(spec, new DateTime(), marquez, new Payment());
	}
	
	public void testAdjustBuyTotal() {
		BuyItems buyItems = new BuyItems();
		buyItems.add(claveles, 20.0, Pesos.newFor(20.0));
		buyItems.add(rosas, 10.0, Pesos.newFor(15.0));

		Pesos adjustedTotal = Pesos.newFor(30.0);
		buyItems.adjustTotal(adjustedTotal);
		
		assertEquals(adjustedTotal, buyItems.total());
	}
	
}
