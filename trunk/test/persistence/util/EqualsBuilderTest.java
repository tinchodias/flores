package persistence.util;


import junit.framework.TestCase;
import persistence.Model;
import persistence.ModelFactory;

public class EqualsBuilderTest extends TestCase {

	public void testEqualsModels() {
		Model model1 = ModelFactory.makeSimpleModel();
		Model model2 = ModelFactory.makeSimpleModel();
		
		assertEqualsModels(model1, model2);
	}
	
	private static void assertEqualsModels(Model model1, Model model2) {
		assertTrue("The models must be equal", EqualsBuilder.reflectionEquals(model1, model2));
		//TODO Para poder hacer una "deep comparison", podr�a implementar
		//EqualsBuilder.reflectionEquals( ) en cada objeto que cuelgue de Model. 
		//Por consiguiente, habr�a que usar adem�s en cada
		//HashCodeBuilder.reflectionHashCode(this).
	}
}
