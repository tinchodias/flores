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
import model.receipt.BuyItems;
import model.stock.Article;
import model.stock.AverageCostStrategy;

import org.joda.time.DateTime;

//TODO Add tests for BuyAnnulment 

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
		
		depot = StoreFixture.emptyStore();
		depot.stock().setCostValuation(new AverageCostStrategy(depot.stock()));
		
		marquez = new JuridicPerson("Marquez");
		depot.suppliers().add(marquez);
		
		paqueteRosa = new Article("Paquete de Rosa x 40");
		paqueteClavel = new Article("Paquete de Clavel");
		depot.stockArticles().add(paqueteClavel);
		depot.stockArticles().add(paqueteRosa);
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

		BuyItems spec = new BuyItems();
		spec.add(paqueteRosa, 21.0, Pesos.newFor(15.0));
		Buy buy = makeBuy(spec);
		
		depot.add(buy);
		
		assertEquals(Pesos.newFor(15.0), depot.stock().cost(paqueteRosa));
		assertEquals(Pesos.newFor(0.0), depot.stock().cost(paqueteClavel));

		BuyItems spec2 = new BuyItems();
		spec2.add(paqueteRosa, 17.0, Pesos.newFor(17.5));
		Buy buy2 = makeBuy(spec2);
		depot.add(buy2);
		
		assertEquals(calculeAverageCost(21.0, 15.0, 17.0, 17.5), depot.stock().cost(paqueteRosa));
		assertEquals(Pesos.newFor(0.0), depot.stock().cost(paqueteClavel));
	}

	private Pesos calculeAverageCost(double oldCount, double oldCost, double inputCount, double inputCost) {
		return Pesos.newFor((oldCount * oldCost + inputCount * inputCost) / (oldCount + inputCount));
	}

	private Buy makeBuy(BuyItems spec) {
		return new Buy(spec, new DateTime(), marquez, new Payment());
	}
	
}
