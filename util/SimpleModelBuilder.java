
import persistence.Model;
import persistence.ModelFactory;
import persistence.ModelPersistence;

public class SimpleModelBuilder {

	public static void main(String[] args) {
		new SimpleModelBuilder().run();
	}

	public void run() {
		ModelPersistence.instance().open();
		Model model = model();
		ModelPersistence.instance().save(model);
	}

	private Model model() {
		return ModelFactory.makeSimpleModel();
	}
	
}