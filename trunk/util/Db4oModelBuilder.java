
import persistence.Model;
import persistence.ModelFactory;
import persistence.ModelPersistence;

public class Db4oModelBuilder {

	public static void main(String[] args) {
		new Db4oModelBuilder().run();
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
