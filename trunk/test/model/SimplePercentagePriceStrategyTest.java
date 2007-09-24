package model;

import junit.framework.TestCase;
import model.money.MoneyAmount;
import model.price.SimplePercentagePriceStrategy;
import model.receipt.Buy;
import model.stock.Article;

public class SimplePercentagePriceStrategyTest extends TestCase {

	private Store store;
	private SimplePercentagePriceStrategy priceStrategy;
	private Article article;
	private JuridicPerson supplier;

	protected void setUp() throws Exception {
		store = StoreFixture.simpleStore();
		article = store.stockArticles().iterator().next();
		supplier = store.suppliers().iterator().next();
		
		priceStrategy = new SimplePercentagePriceStrategy(store);
	}

	public void testSimple() {
		priceStrategy.setDefaultPriceMargin(50.0);

		assertEquals(MoneyAmount.newFor(0.0), priceStrategy.priceFor(article));
		
		Buy buy = StoreFixture.simpleBuy(article, supplier);
		store.add(buy);
		
		assertEquals(MoneyAmount.newFor(30.0), priceStrategy.priceFor(article));
		
		priceStrategy.setPriceMargin(article, 75.0);
		
		assertEquals(MoneyAmount.newFor(35.0), priceStrategy.priceFor(article));
	}

}
