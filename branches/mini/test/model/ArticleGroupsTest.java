/**
 * 
 */
package model;

import junit.framework.TestCase;
import model.stock.ArticleGroup;

public class ArticleGroupsTest extends TestCase {

	private Store store;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		store = StoreFixture.simpleStore();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testAddArticleGroup() {
		ArticleGroup floreriaGroup = new ArticleGroup("Floreria");
		store.stockArticleGroups().add(floreriaGroup);
		
		assertTrue(store.stockArticleGroups().contains(floreriaGroup));
	}

	//TODO Agregar más tests! Definir cuántos grupos puede tener cada artículo. 
	
}
