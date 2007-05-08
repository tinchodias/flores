/**
 * 
 */
package model;

import com.sun.xml.internal.bind.v2.TODO;

import junit.framework.TestCase;
import model.stock.Article;
import model.stock.ArticleGroup;

public class ArticleGroupsTest extends TestCase {

	private Store store;
	private Article clavel;
	private Article alquiler;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		store = StoreFactory.makeSimpleStore();
		
		clavel = store.stockArticles().iterator().next();
		
		alquiler = store.expensesArticles().iterator().next();
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
