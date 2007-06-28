
import persistence.Model;
import persistence.ModelFactory;
import persistence.ModelPersistence;

public class StressModelBuilder {

	public static void main(String[] args) {
		new StressModelBuilder().run();
	}

	public void run() {
		ModelPersistence.instance().open();
		Model model = model();
		ModelPersistence.instance().save(model);
	}

	private Model model() {
		return ModelFactory.makeStressModel();
	}
	
}
