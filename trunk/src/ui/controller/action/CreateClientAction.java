package ui.controller.action;

import message.MessageId;
import model.JuridicPerson;
import model.Store;
import model.address.Address;
import model.address.City;
import persistence.ModelPersistence;
import ui.view.component.ClientUI;

public class CreateClientAction implements Action {

	private final ClientUI clientUI;

	public CreateClientAction(ClientUI clientUI) {
		this.clientUI = clientUI;
	}
	
	public void execute() {
		JuridicPerson client = client();
		Store store = ModelPersistence.instance().loadedModel().store();
		store.clients().add(client);
		
		clientUI.setVisible(false);
	}

	private JuridicPerson client() {
		String name = clientUI.getClientName();
		Address address = address();
		return new JuridicPerson(name, address);
	}

	private Address address() {
		String address = clientUI.getAddressUI().getAddress();
		City city = clientUI.getAddressUI().getCity();
		return new Address(address, city);
	}

	public MessageId messageId() {
		return MessageId.accept;
	}

}
