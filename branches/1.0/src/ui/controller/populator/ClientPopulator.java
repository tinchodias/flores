package ui.controller.populator;

import model.JuridicPerson;
import model.address.Address;
import persistence.ModelPersistence;
import ui.view.component.ClientUI;

public class ClientPopulator implements DetailPopulator<JuridicPerson, ClientUI> {

	public JuridicPerson createFrom(ClientUI ui) {
		String name = ui.getClientName();
		Address address = new AddressPopulator().createFrom(ui.getAddressUI());
		JuridicPerson client = new JuridicPerson(name, address);

		ModelPersistence.instance().loadedModel().store().clients().add(client);
		return client;
	}

	public void modifyFrom(ClientUI ui, JuridicPerson object) {
		object.setName(ui.getClientName());
		new AddressPopulator().modifyFrom(ui.getAddressUI(), object.getAddress());
	}

	public void showIn(ClientUI ui, JuridicPerson object) {
		ui.setClientName(object.getName());
		new AddressPopulator().showIn(ui.getAddressUI(), object.getAddress());
	}
	
}
