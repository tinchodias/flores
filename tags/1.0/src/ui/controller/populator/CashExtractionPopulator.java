package ui.controller.populator;

import model.cashBook.CashExtraction;

import org.joda.time.DateTime;

import persistence.ModelPersistence;
import ui.view.component.CashExtractionUI;

import com.db4o.foundation.NotSupportedException;

public class CashExtractionPopulator implements DetailPopulator<CashExtraction, CashExtractionUI>{

	public CashExtraction createFrom(CashExtractionUI ui) {
		CashExtraction extraction = new CashExtraction(new DateTime(), ui.getAmount(), ui.getNote());
		
		ModelPersistence.instance().loadedModel().store().cashBook().add(extraction);
		return extraction;
	}

	public void modifyFrom(CashExtractionUI ui, CashExtraction object) {
		throw new NotSupportedException();
	}

	public void showIn(CashExtractionUI ui, CashExtraction object) {
		ui.setAmount(object.getAmount());
		ui.setNote(object.getNote());
	}

}
