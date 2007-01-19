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

public class BuyTest extends TestCase {

	private Store depot;
	private Article paqueteRosa;
	private Article paqueteClavel;
	private JuridicPerson marquez;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		depot = TestsCommonFactory.makeEmptyStore();

		marquez = new JuridicPerson("Marquez");
		depot.clients().add(marquez);
		
		paqueteRosa = new Article("RO40", "Paquete de Rosa x 40");
		paqueteClavel = new Article("CL", "Paquete de Clavel");
		depot.articles().add(paqueteClavel);
		depot.articles().add(paqueteRosa);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testDoubleBuy() {

		{
			ArticleSpecification spec = new ArticleSpecification();
			spec.add(paqueteClavel, 20.0, Pesos.newFor(20.0));
			spec.add(paqueteRosa, 10.0, Pesos.newFor(15.0));
	
			Buy buy = new Buy(spec, new Date(), marquez, new Payment());
			depot.add(buy);
		}
		
		assertEquals(20.0, depot.stock().count(paqueteClavel));
		assertEquals(10.0, depot.stock().count(paqueteRosa));

		{
			ArticleSpecification spec = new ArticleSpecification();
			spec.add(paqueteClavel, 100.0, Pesos.newFor(20.0));
			spec.add(paqueteRosa, 200.0, Pesos.newFor(15.0));

			Buy buy = new Buy(spec, new Date(), marquez, new Payment());
			depot.add(buy);
		}
		
		assertEquals(120.0, depot.stock().count(paqueteClavel));
		assertEquals(210.0, depot.stock().count(paqueteRosa));
	}
	
}
