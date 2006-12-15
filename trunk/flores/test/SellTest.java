/**
 * 
 */
package flores.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;
import money.Cash;
import money.Check;
import money.Pay;
import money.Pesos;
import flores.Article;
import flores.Depot;
import flores.JuridicPerson;
import flores.receipt.ArticleSpecification;
import flores.receipt.Buy;
import flores.receipt.Sell;

public class SellTest extends TestCase {

	private Depot depot;
	private Article paqueteRosa;
	private Article paqueteClavel;
	private JuridicPerson elvira;
	private JuridicPerson marquez;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		depot = TestsCommonFactory.makeEmptyDepot();

		elvira = new JuridicPerson("Elvira");
		depot.clients().add(elvira);

		marquez = new JuridicPerson("Marquez");
		depot.suppliers().add(marquez);
		
		paqueteRosa = new Article("RO40", "Paquete de Rosa x 40");
		paqueteClavel = new Article("CL", "Paquete de Clavel");
		depot.articles().add(paqueteClavel);
		depot.articles().add(paqueteRosa);

		ArticleSpecification spec = new ArticleSpecification();
		spec.add(paqueteClavel, 2000.0, Pesos.newFor(20.0));
		spec.add(paqueteRosa, 10.0, Pesos.newFor(15.0));
		Buy buy = new Buy(spec, new Date(), marquez, new HashSet());
		depot.add(buy);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testSell() {
		ArticleSpecification spec = new ArticleSpecification();
		spec.add(paqueteClavel, 100.0, Pesos.newFor(9.0));
		spec.add(paqueteRosa, 5.0, Pesos.newFor(40.5));
		
		Set<Pay> payment = new HashSet<Pay>();
		payment.add(new Cash(Pesos.newFor(900.0)));
		payment.add(new Check(Pesos.newFor(200.0), "12345678E"));
		
		Sell sell = new Sell(spec, new Date(), elvira, payment);
		depot.add(sell);
	}
}