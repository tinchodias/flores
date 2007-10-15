/**
 * 
 */
package model;

import junit.framework.TestCase;
import persistence.ModelPersistence;
import persistence.util.ModelPersistenceFixture;

public class ClientTest extends TestCase {

	private Store store;

	protected void setUp() throws Exception {
		ModelPersistenceFixture.mockWithSimpleModel();
		store = ModelPersistence.instance().loadedModel().store();
		store.clients().clear();
	}

	public void testAddClients() {
		assertEquals(0, store.clients().size());

		JuridicPerson elvira = StoreFixture.simpleClient(store);
		JuridicPerson cuca = StoreFixture.simpleClient(store);
		store.clients().add(elvira);
		store.clients().add(cuca);
		
		assertEquals(2, store.clients().size());
	}
	
}
