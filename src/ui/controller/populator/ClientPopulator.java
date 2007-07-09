package ui.controller.populator;

import model.JuridicPerson;
import model.Store;
import persistence.ModelPersistence;
import ui.view.component.ClientUI;

public class ClientPopulator extends DetailPopulator<JuridicPerson, ClientUI> {

	public void createFrom(ClientUI ui) {
		String name = ui.getClientName();
		JuridicPerson client = new JuridicPerson(name);
		//TODO ugly
		new AddressPopulator(client).createFrom(ui.getAddressUI());

		Store store = ModelPersistence.instance().loadedModel().store();
		store.clients().add(client);
	}

	public void modifyFrom(ClientUI ui) {
		getValue().setName(ui.getClientName());
		new AddressPopulator(getValue()).modifyFrom(ui.getAddressUI());
	}

	public void showIn(ClientUI ui) {
		ui.setClientName(getValue().getName());
		new AddressPopulator(getValue()).showIn(ui.getAddressUI());
	}
	
}
