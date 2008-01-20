package ui.controller.populator;

import model.debts.ClientDebtCancellation;

import org.joda.time.DateTime;

import persistence.ModelPersistence;
import ui.view.component.ClientDebtCancellationUI;

import com.db4o.foundation.NotSupportedException;

public class ClientDebtCancellationPopulator implements DetailPopulator<ClientDebtCancellation, ClientDebtCancellationUI>{

	public ClientDebtCancellation createFrom(ClientDebtCancellationUI ui) {
		ClientDebtCancellation cancellation = new ClientDebtCancellation(ui.getClient(), ui.getAmount(), new DateTime());
		
		ModelPersistence.instance().loadedModel().store().debts().add(cancellation);
		return cancellation;
	}

	public void modifyFrom(ClientDebtCancellationUI ui, ClientDebtCancellation object) {
		throw new NotSupportedException();
	}

	public void showIn(ClientDebtCancellationUI ui, ClientDebtCancellation object) {
		throw new NotSupportedException();
	}

}
