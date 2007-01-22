/**
 * 
 */
package model.test;

import java.util.Date;

import junit.framework.TestCase;
import model.JuridicPerson;
import model.Store;
import model.receipt.Sell;
import model.stock.Article;
import model.stock.StockDropOut;

public class StockDropOutTest extends TestCase {

	private Store store;
	private Article clavel;
	private JuridicPerson elvira;
	private Sell sell;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		store = TestsCommonFactory.makeSimpleStore();
		
		clavel = store.articles().iterator().next();
		
		elvira = store.clients().iterator().next();
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

//TODO Finish this
//	public void testInvalidDropOut() {
//		double initialStock = store.stock().count(clavel);
//
//		try {
//			doDropOut(clavel, 3000.0);
//			fail("Must throw an exception");
//		} catch (InvalidOperationException e) {
//		}
//	}
	
	private void doDropOut(Article article, double count) {
		StockDropOut dropOut = new StockDropOut(article, count, new Date());
		store.stock().add(dropOut);
	}
}
