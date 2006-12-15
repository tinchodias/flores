/**
 * 
 */
package flores.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import money.Cash;
import money.Check;
import money.Pay;
import money.Pesos;

import junit.framework.TestCase;
import flores.Article;
import flores.Depot;
import flores.JuridicPerson;
import flores.receipt.ArticleSpecification;
import flores.receipt.Buy;

public class BuyTest extends TestCase {

	private Depot depot;
	private Article paqueteRosa;
	private Article paqueteClavel;
	private JuridicPerson marquez;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		depot = TestsCommonFactory.makeEmptyDepot();

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
	
			Set<Pay> payment = new HashSet<Pay>();
			
			Buy buy = new Buy(spec, new Date(), marquez, payment);
			depot.add(buy);
		}
		
		assertEquals(20.0, depot.stock().count(paqueteClavel));
		assertEquals(10.0, depot.stock().count(paqueteRosa));

		{
			ArticleSpecification spec = new ArticleSpecification();
			spec.add(paqueteClavel, 100.0, Pesos.newFor(20.0));
			spec.add(paqueteRosa, 200.0, Pesos.newFor(15.0));

			Set<Pay> payment = new HashSet<Pay>();
			
			Buy buy = new Buy(spec, new Date(), marquez, payment);
			depot.add(buy);
		}
		
		assertEquals(120.0, depot.stock().count(paqueteClavel));
		assertEquals(210.0, depot.stock().count(paqueteRosa));
	}
	
}
