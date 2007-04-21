package persistence;


import junit.framework.TestCase;

public class PersistenceTest extends TestCase {

	private ModelPersistence modelPersistence;
	private Model savedModel;

	public void setUp() throws Exception {
		modelPersistence = ModelPersistence.instance();
		
		saveModel();
	}

	public void tearDown() throws Exception {
	}

	private void saveModel() {
		savedModel = ModelFactory.makeSimpleModel();
		
		modelPersistence.save(savedModel);
	}

	public void testSave() throws Exception {
		Model loadedModel = modelPersistence.load();
		
		assertEqualModels(savedModel, loadedModel);
	}

	private void assertEqualModels(Model model1, Model model2) {
	}
}
