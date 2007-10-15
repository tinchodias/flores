/**
 * 
 */
package model;

import persistence.ModelPersistence;
import persistence.util.ModelPersistenceFixture;
import junit.framework.TestCase;
import model.stock.ArticleGroup;

public class ArticleGroupsTest extends TestCase {

	private Store store;
	
	protected void setUp() throws Exception {
		ModelPersistenceFixture.mockWithSimpleModel();
		store = ModelPersistence.instance().loadedModel().store();
	}

	public void testAddArticleGroup() {
		ArticleGroup floreriaGroup = new ArticleGroup("Floreria");
		store.stockArticleGroups().add(floreriaGroup);
		
		assertTrue(store.stockArticleGroups().contains(floreriaGroup));
	}

}
