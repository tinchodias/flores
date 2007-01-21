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
import model.stock.AverageCostValuation;

// TODO: add tests for BuyAnnulment 

public class AverageCostValuationTest extends TestCase {

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
		depot.stock().setCostValuation(new AverageCostValuation(depot.stock()));
		
		marquez = new JuridicPerson("Marquez");
		depot.suppliers().add(marquez);
		
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

	public void testSimpleValuation() {
		assertEquals(Pesos.newFor(0.0), depot.stock().cost(paqueteRosa));
		assertEquals(Pesos.newFor(0.0), depot.stock().cost(paqueteClavel));

		ArticleSpecification spec = new ArticleSpecification();
		spec.add(paqueteRosa, 21.0, Pesos.newFor(15.0));
		Buy buy = makeBuy(spec);
		
		depot.add(buy);
		
		assertEquals(Pesos.newFor(15.0), depot.stock().cost(paqueteRosa));
		assertEquals(Pesos.newFor(0.0), depot.stock().cost(paqueteClavel));

		ArticleSpecification spec2 = new ArticleSpecification();
		spec2.add(paqueteRosa, 17.0, Pesos.newFor(17.5));
		Buy buy2 = makeBuy(spec2);
		depot.add(buy2);
		
		assertEquals(calculeAverageCost(21.0, 15.0, 17.0, 17.5), depot.stock().cost(paqueteRosa));
		assertEquals(Pesos.newFor(0.0), depot.stock().cost(paqueteClavel));
	}

	private Pesos calculeAverageCost(double oldCount, double oldCost, double inputCount, double inputCost) {
		return Pesos.newFor((oldCount * oldCost + inputCount * inputCost) / (oldCount + inputCount));
	}

	private Buy makeBuy(ArticleSpecification spec) {
		return new Buy(spec, new Date(), marquez, new Payment());
	}
	
}
