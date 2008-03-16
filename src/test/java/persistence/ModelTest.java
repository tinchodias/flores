package persistence;

import junit.framework.TestCase;
import security.User;
import security.UserFixture;

public class ModelTest extends TestCase {

	private Model model1;
	private Model model2;

	protected void setUp() throws Exception {
		super.setUp();
		model1 = ModelFixture.simpleModel();
		model2 = ModelFixture.simpleModel();
	}

	/* TODO
	public void testEquals() {
		assertNotSame(model1, model2); //tests the model factory...
		assertTrue(model1.equals(model2));
	}
	*/

	public void testNotEquals() {
		applyChange(model1);
		assertFalse(model1.equals(model2));
	}

	private void applyChange(Model model) {
		User admin = model.users().get(UserFixture.adminUserName());
		model.users().remove(admin);
	}

}
