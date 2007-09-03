package ui.controller.populator;

import model.exception.InvalidOperationException;
import model.stock.StockDropOut;

import org.joda.time.DateTime;

import persistence.ModelPersistence;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import ui.view.component.StockDropOutUI;

public class StockDropOutPopulator implements DetailPopulator<StockDropOut, StockDropOutUI> {

	public StockDropOut createFrom(StockDropOutUI ui) {
		StockDropOut dropOut = new StockDropOut(ui.getArticle(), ui.getCount(), new DateTime());
		ModelPersistence.instance().loadedModel().store().stock().add(dropOut);
		return dropOut;
	}

	public void modifyFrom(StockDropOutUI ui, StockDropOut object) {
		throw new InvalidOperationException();
	}

	public void showIn(StockDropOutUI ui, StockDropOut object) {
		throw new NotImplementedException();
	}

}
