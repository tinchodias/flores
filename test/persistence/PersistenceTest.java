package persistence;


import model.Store;
import model.TestsCommonFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersistenceTest {

	private ModelPersistence modelPersistence;

	@Before
	public void setUp() throws Exception {
		modelPersistence = ModelPersistence.instance();
		
		saveModel();
	}

	private void saveModel() {
		Store store = TestsCommonFactory.makeSimpleStore();
		Model model = new Model(store);
		
		modelPersistence.save(model);
		
		//TODO Finish this
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSave() {
	}
}
