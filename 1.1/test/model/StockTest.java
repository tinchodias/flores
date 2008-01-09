package model;

import model.money.MoneyAmount;
import model.receipt.Sell;
import model.stock.Article;
import junit.framework.TestCase;
import persistence.ModelPersistence;
import persistence.util.ModelPersistenceFixture;
import validation.ModelValidationError;

public class StockTest extends TestCase {

	private Store store;
	private Article anArticle;
	private JuridicPerson aClient;
	private Vendor aVendor;

	protected void setUp() throws Exception {
		ModelPersistenceFixture.mockWithSimpleModel();
		store = ModelPersistence.instance().loadedModel().store();
		
		anArticle = StoreFixture.simpleArticle(store);
		store.stockArticles().add(anArticle);
		
		aClient = store.clients().iterator().next();
		aVendor = store.vendors().iterator().next();
	}

	public void testStockNotNegative() {
		try {
			Sell anInvalidSell = StoreFixture.simpleSell(anArticle, aClient, aVendor, MoneyAmount.zero());
			store.stock().apply(anInvalidSell);
			fail("May not sell if there isn't enough stock");
		} catch (ModelValidationError e) {
		}
	}
}
