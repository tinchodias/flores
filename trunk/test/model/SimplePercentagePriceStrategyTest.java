package model;

import persistence.ModelPersistence;
import persistence.util.ModelPersistenceFixture;
import junit.framework.TestCase;
import model.money.MoneyAmount;
import model.price.SimplePercentagePriceStrategy;
import model.receipt.Buy;
import model.stock.Article;
import model.util.Percentage;

public class SimplePercentagePriceStrategyTest extends TestCase {

	private Store store;
	private SimplePercentagePriceStrategy priceStrategy;
	private Article article;
	private JuridicPerson supplier;

	protected void setUp() throws Exception {
		ModelPersistenceFixture.mockWithSimpleModel();
		store = ModelPersistence.instance().loadedModel().store();
		article = store.stockArticles().iterator().next();
		supplier = store.suppliers().iterator().next();
		priceStrategy = new SimplePercentagePriceStrategy(store);
	}

	public void testSimple() {
		priceStrategy.setDefaultPriceMargin(Percentage.newFor(0.5));

		assertEquals(MoneyAmount.zero(), priceStrategy.priceFor(article));
		
		Buy buy = StoreFixture.simpleBuy(article, supplier);
		store.add(buy);
		
		assertEquals(MoneyAmount.newFor(30.0), priceStrategy.priceFor(article));
		
		priceStrategy.setPriceMargin(article, Percentage.newFor(0.75));
		
		assertEquals(MoneyAmount.newFor(35.0), priceStrategy.priceFor(article));
	}

}
