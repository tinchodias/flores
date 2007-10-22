
import java.io.File;

import model.StoreFixture;
import model.price.SimplePercentagePriceStrategy;
import model.util.Percentage;
import persistence.Model;
import persistence.ModelFixture;
import persistence.ModelPersistence;
import persistence.db4o.Db4oModelPersistence;
import transaction.Block;

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
		final Model model = ModelFixture.simpleModelWithEmptyStore();
		persistence.save(model);

		persistence.transactionManager().execute(new Block() {
			public void executeBlock() {
				fillModel(model);
			}
		});
	}

	private void fillModel(Model model) {
		//fills the store
		StoreFixture.fillStressed(model.store());

		//extra
		((SimplePercentagePriceStrategy) model.store().priceStrategy()).setDefaultPriceMargin(Percentage.newFor(0.5));
	}
	
}
