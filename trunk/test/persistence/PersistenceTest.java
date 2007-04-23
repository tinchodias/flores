package persistence;


import junit.framework.TestCase;

public abstract class PersistenceTest extends TestCase {

	private ModelPersistence modelPersistence;
	private Model savedModel;

	public void setUp() throws Exception {
		modelPersistence = modelPersistenceInstance();
		modelPersistence.open();
		saveModel();
	}

	public void tearDown() throws Exception {
		modelPersistence.close();
	}

	protected abstract ModelPersistence modelPersistenceInstance();

	private void saveModel() {
		savedModel = ModelFactory.makeSimpleModel();
		
		modelPersistence.save(savedModel);
	}

	public void testSave() throws Exception {
		Model loadedModel = modelPersistence.load();
		
		assertEqualModels(savedModel, loadedModel);
	}

	private void assertEqualModels(Model model1, Model model2) {
		//TODO comparar modelos!
	}
}
