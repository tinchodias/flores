/**
 * 
 */
package model;

import junit.framework.TestCase;
import model.exception.InvalidOperationException;
import model.stock.Article;
import model.stock.StockDropOut;

import org.joda.time.DateTime;

public class StockDropOutTest extends TestCase {

	private Store store;
	private Article clavel;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		store = StoreFixture.simpleStore();
		
		clavel = store.stockArticles().iterator().next();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
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
			doDropOut(clavel, 3000.0);
			fail("Must throw an exception");
		} catch (InvalidOperationException e) {
		}
		
		assertEquals(initialStock, store.stock().count(clavel));
	}
	
	private void doDropOut(Article article, double count) {
		StockDropOut dropOut = new StockDropOut(article, count, new DateTime());
		store.stock().add(dropOut);
	}
}
