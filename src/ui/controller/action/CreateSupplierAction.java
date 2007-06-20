package ui.controller.action;

import message.MessageId;
import model.JuridicPerson;
import model.Store;
import model.address.Address;
import model.address.City;
import persistence.ModelPersistence;
import ui.view.component.SupplierUI;

public class CreateSupplierAction implements Action {

	private final SupplierUI supplierUI;

	public CreateSupplierAction(SupplierUI supplierUI) {
		this.supplierUI = supplierUI;
	}
	
	public void execute() {
		JuridicPerson client = client();
		Store store = ModelPersistence.instance().loadedModel().store();
		store.suppliers().add(client);
		
		supplierUI.setVisible(false);
	}

	private JuridicPerson client() {
		String name = supplierUI.getSupplierName();
		Address address = address();
		return new JuridicPerson(name, address);
	}

	private Address address() {
		String address = supplierUI.getAddressUI().getAddress();
		City city = supplierUI.getAddressUI().getCity();
		return new Address(address, city);
	}

	public MessageId messageId() {
		return MessageId.accept;
	}

}
