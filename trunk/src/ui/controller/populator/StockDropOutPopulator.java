package ui.controller.populator;

import model.exception.InvalidOperationException;
import model.stock.StockDropOut;

import org.joda.time.DateTime;

import persistence.ModelPersistence;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import ui.view.component.StockDropOutUI;

public class StockDropOutPopulator extends DetailPopulator<StockDropOut, StockDropOutUI> {

	public void createFrom(StockDropOutUI ui) {
		StockDropOut dropOut = new StockDropOut(ui.getArticle(), ui.getCount(), new DateTime());
		ModelPersistence.instance().loadedModel().store().stock().add(dropOut);
	}

	public void modifyFrom(StockDropOutUI ui) {
		throw new InvalidOperationException();
	}

	public void showIn(StockDropOutUI ui) {
		throw new NotImplementedException();
	}

}
