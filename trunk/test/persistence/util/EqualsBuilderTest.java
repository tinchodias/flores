package persistence.util;


import junit.framework.TestCase;
import persistence.Model;
import persistence.ModelFixture;

public class EqualsBuilderTest extends TestCase {

	public void testEqualsModels() {
		Model model1 = ModelFixture.simpleModel();
		Model model2 = ModelFixture.simpleModel();
		
		assertEqualsModels(model1, model2);
	}
	
	private static void assertEqualsModels(Model model1, Model model2) {
		assertTrue("The models must be equal", EqualsBuilder.reflectionEquals(model1, model2));
		//TODO Para poder hacer una "deep comparison", podría implementar
		//EqualsBuilder.reflectionEquals( ) en cada objeto que cuelgue de Model. 
		//Por consiguiente, habría que usar además en cada
		//HashCodeBuilder.reflectionHashCode(this).
	}
}
