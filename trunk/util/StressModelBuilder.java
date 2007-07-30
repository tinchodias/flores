
import java.io.File;

import model.StoreFixture;
import persistence.Model;
import persistence.ModelFixture;
import persistence.ModelPersistence;
import persistence.db4o.Db4oModelPersistence;

public class StressModelBuilder {

	public static void main(String[] args) {
		new StressModelBuilder().run();
	}

	public void run() {
		//FIXME Deletes the old file
		Db4oModelPersistence persistence = (Db4oModelPersistence) ModelPersistence.instance();
		new File(persistence.getFileName()).delete();
		
		//Saves a model
		persistence.open();
		Model model = ModelFixture.simpleModelWithEmptyStore();
		persistence.save(model);

		//fills the store
		StoreFixture.fillStressed(model.store());
		
		System.out.println(model.store().cashBook().currentCash());
	}
	
}
