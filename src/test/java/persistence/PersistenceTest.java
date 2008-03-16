package persistence;


import junit.framework.TestCase;

public abstract class PersistenceTest extends TestCase {

	private ModelPersistence modelPersistence;
	private Model savedModel;

	public void setUp() throws Exception {
		modelPersistence = modelPersistenceInstance();
		modelPersistence.open();
		saveModel();
		modelPersistence.close();
		modelPersistence.open();
	}

	public void tearDown() throws Exception {
		modelPersistence.close();
	}

	protected abstract ModelPersistence modelPersistenceInstance();

	private void saveModel() {
		savedModel = ModelFixture.simpleModel();
		modelPersistence.save(savedModel);
	}

	public void testInvalidLoad() {
		modelPersistence.close();
		try {
			modelPersistence.load();
			fail("Load on a closed ModelPersistence must throw an exception");
		} catch (Exception e) {
		}
	}
	
	public void testNotSameModelAfterReload() throws Exception {
		Model loadedModel = modelPersistence.load();
		assertNotSame(savedModel, loadedModel);
	}

	/* TODO
	public void testModelEqualsAfterReload() throws Exception {
		Model loadedModel = modelPersistence.load();
		assertEqualsModels(savedModel, loadedModel);
	}
	
	private static void assertEqualsModels(Model model1, Model model2) {
		assertTrue("The models must be equal", EqualsBuilder.reflectionEquals(model1, model2));
		//TODO Para poder hacer una "deep comparison", podr�a implementar
		//EqualsBuilder.reflectionEquals( ) en cada objeto que cuelgue de Model. 
		//Por consiguiente, habr�a que usar adem�s en cada
		//HashCodeBuilder.reflectionHashCode(this).
	}
	*/
}
