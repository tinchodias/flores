package ui.controller.populator;

import model.JuridicPerson;
import model.Store;
import persistence.ModelPersistence;
import ui.view.component.SupplierUI;

public class SupplierPopulator extends DetailPopulator<JuridicPerson, SupplierUI> {

	public void createFrom(SupplierUI ui) {
		String name = ui.getSupplierName();
		JuridicPerson supplier = new JuridicPerson(name);
		//TODO ugly
		new AddressPopulator(supplier).createFrom(ui.getAddressUI());

		Store store = ModelPersistence.instance().loadedModel().store();
		store.suppliers().add(supplier);
	}

	public void modifyFrom(SupplierUI ui) {
		getValue().setName(ui.getSupplierName());
		new AddressPopulator(getValue()).modifyFrom(ui.getAddressUI());
	}

	public void showIn(SupplierUI ui) {
		ui.setSupplierName(getValue().getName());
		new AddressPopulator(getValue()).showIn(ui.getAddressUI());
	}
	
}
