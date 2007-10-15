/**
 * 
 */
package model;

import junit.framework.TestCase;
import model.money.MoneyAmount;
import model.money.Payment;
import model.receipt.Buy;
import model.receipt.BuyItems;
import model.stock.Article;
import model.stock.cost.AverageCostStrategy;

import org.joda.time.DateTime;

import persistence.ModelPersistence;
import persistence.util.ModelPersistenceFixture;

//TODO Add tests for BuyCancellation 

public class AverageCostStrategyTest extends TestCase {

	private Store store;
	private Article paqueteRosa;
	private Article paqueteClavel;
	private JuridicPerson marquez;

	protected void setUp() throws Exception {
		ModelPersistenceFixture.mockWithSimpleModel();
		store = ModelPersistence.instance().loadedModel().store();
		store.stock().setCostStrategy(new AverageCostStrategy(store.stock()));
		
		marquez = store.suppliers().iterator().next();
		store.suppliers().add(marquez);
		
		paqueteRosa = new Article("Paquete de Rosa x 40");
		paqueteClavel = new Article("Paquete de Clavel");
		store.stockArticles().add(paqueteClavel);
		store.stockArticles().add(paqueteRosa);
	}

	public void testSimpleValuation() {
		assertEquals(MoneyAmount.newFor(0.0), store.stock().cost(paqueteRosa));
		assertEquals(MoneyAmount.newFor(0.0), store.stock().cost(paqueteClavel));

		Buy buy = makeBuy(paqueteRosa, 21.0, MoneyAmount.newFor(15.0));
		
		store.add(buy);
		
		assertEquals(MoneyAmount.newFor(15.0), store.stock().cost(paqueteRosa));
		assertEquals(MoneyAmount.newFor(0.0), store.stock().cost(paqueteClavel));

		Buy buy2 = makeBuy(paqueteRosa, 17.0, MoneyAmount.newFor(17.5));
		store.add(buy2);
		
		assertEquals(calculeAverageCost(21.0, 15.0, 17.0, 17.5), store.stock().cost(paqueteRosa));
		assertEquals(MoneyAmount.newFor(0.0), store.stock().cost(paqueteClavel));
	}

	private MoneyAmount calculeAverageCost(double oldCount, double oldCost, double inputCount, double inputCost) {
		return MoneyAmount.newFor((oldCount * oldCost + inputCount * inputCost) / (oldCount + inputCount));
	}

	private Buy makeBuy(Article article, double count, MoneyAmount value) {
		BuyItems spec = new BuyItems();
		spec.add(article, count, value);
		return new Buy(spec, new DateTime(), marquez, new Payment());
	}
	
}
