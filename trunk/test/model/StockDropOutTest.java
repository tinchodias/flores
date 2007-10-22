/**
 * 
 */
package model;

import junit.framework.TestCase;
import model.money.MoneyAmount;
import model.stock.Article;
import model.stock.StockDropOut;

import org.joda.time.DateTime;

import persistence.ModelPersistence;
import persistence.util.ModelPersistenceFixture;
import validation.ModelValidationError;

public class StockDropOutTest extends TestCase {

	private Store store;
	private Article clavel;
	
	protected void setUp() throws Exception {
		ModelPersistenceFixture.mockWithSimpleModel();
		store = ModelPersistence.instance().loadedModel().store();
		
		clavel = store.stockArticles().iterator().next();
		
		JuridicPerson aSupplier = store.suppliers().iterator().next();
		store.add(StoreFixture.simpleBuy(clavel, aSupplier));
	}

	public void testValidDropOut() {
		double initialStock = store.stock().count(clavel);

		doDropOut(clavel, 100.0);
		
		assertEquals(initialStock - 100.0, store.stock().count(clavel));

		doDropOut(clavel, 50.0);
		
		assertEquals(initialStock - 150.0, store.stock().count(clavel));
	}

	public void testInvalidDropOut() {
		double initialStock = store.stock().count(clavel);

		try {
			doDropOut(clavel, store.stock().count(clavel) + 1);
			fail("Must throw an exception");
		} catch (ModelValidationError e) {
		}
		
		assertEquals(initialStock, store.stock().count(clavel));
	}
	
	private void doDropOut(Article article, double count) {
		StockDropOut dropOut = new StockDropOut(article, count, new DateTime(), "aTestDropOut", MoneyAmount.zero());
		store.stock().add(dropOut);
	}
}
