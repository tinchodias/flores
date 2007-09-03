package ui.controller.populator;

import model.JuridicPerson;
import model.address.Address;
import persistence.ModelPersistence;
import ui.view.component.SupplierUI;

public class SupplierPopulator implements DetailPopulator<JuridicPerson, SupplierUI> {

	public JuridicPerson createFrom(SupplierUI ui) {
		String name = ui.getSupplierName();
		Address address = new AddressPopulator().createFrom(ui.getAddressUI());
		JuridicPerson supplier = new JuridicPerson(name, address);

		ModelPersistence.instance().loadedModel().store().suppliers().add(supplier);
		return supplier;
	}

	public void modifyFrom(SupplierUI ui, JuridicPerson object) {
		object.setName(ui.getSupplierName());
		new AddressPopulator().modifyFrom(ui.getAddressUI(), object.getAddress());
	}

	public void showIn(SupplierUI ui, JuridicPerson object) {
		ui.setSupplierName(object.getName());
		new AddressPopulator().showIn(ui.getAddressUI(), object.getAddress());
	}
	
}
