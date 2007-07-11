package model;

import junit.framework.TestCase;
import model.money.Pesos;
import model.price.SimplePercentagePriceStrategy;
import model.receipt.Buy;
import model.stock.Article;

public class SimplePercentagePriceStrategyTest extends TestCase {

	private Store store;
	private SimplePercentagePriceStrategy priceStrategy;
	private Article article;
	private JuridicPerson supplier;

	public void setUp() throws Exception {
		store = StoreFixture.simpleStore();
		article = store.stockArticles().iterator().next();
		supplier = store.suppliers().iterator().next();
		
		priceStrategy = new SimplePercentagePriceStrategy(store);
	}

	public void testSimple() {
		priceStrategy.setGeneralPercentage(1.5);

		assertEquals(Pesos.newFor(0.0), priceStrategy.priceFor(article));
		
		Buy buy = StoreFixture.simpleBuy(article, supplier);
		store.add(buy);
		
		assertEquals(Pesos.newFor(30.0), priceStrategy.priceFor(article));
	}

}
