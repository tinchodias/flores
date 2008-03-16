package persistence.db4o;

import java.io.File;

import persistence.PersistenceTest;

public class Db4oPersistenceTest extends PersistenceTest {

	private String modelFileName() {
		return "PersistenceTestModel.db4o";
	}

	@Override
	protected Db4oModelPersistence modelPersistenceInstance() {
		deleteDb4oFile();
		Db4oModelPersistence db4oModelPersistence = new Db4oModelPersistence();
		db4oModelPersistence.setFileName(modelFileName());
		return db4oModelPersistence;
	}

	public void tearDown() throws Exception {
		super.tearDown();
		deleteDb4oFile();
	}

	private void deleteDb4oFile() {
		File file = new File(modelFileName());
		if (file.exists()) {
			assertTrue(file.delete());
		}
	}

}
