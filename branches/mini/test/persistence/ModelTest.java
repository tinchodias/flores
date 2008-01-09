package persistence;

import security.User;
import security.UserFixture;
import junit.framework.TestCase;

public class ModelTest extends TestCase {

	private Model model1;
	private Model model2;

	protected void setUp() throws Exception {
		super.setUp();
		model1 = ModelFixture.simpleModel();
		model2 = ModelFixture.simpleModel();

		//tests the model factory...
		assertNotSame(model1, model2);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testEquals() {
		assertTrue(model1.equals(model2));
	}

	public void testNotEquals() {
		applyChange(model1);
		assertFalse(model1.equals(model2));
	}

	private void applyChange(Model model) {
		User admin = model.users().get(UserFixture.adminUserName());
		model.users().remove(admin);
	}

}
