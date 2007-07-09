package ui.controller.populator;

import model.JuridicPerson;
import model.address.Address;
import model.address.City;
import ui.view.component.AddressUI;

public class AddressPopulator extends DetailPopulator<Address, AddressUI> {

	private JuridicPerson person;

	public AddressPopulator() {
	}
	
	public AddressPopulator(JuridicPerson person) {
		this.person = person;
		setValue(person.getAddress());
	}
	
	public void createFrom(AddressUI ui) {
		String address = ui.getAddress();
		City city = ui.getCity();
		person.setAddress(new Address(address, city));
	}

	public void modifyFrom(AddressUI ui) {
		getValue().setAddress(ui.getAddress());
		getValue().setCity(ui.getCity());
	}

	public void showIn(AddressUI ui) {
		ui.setAddress(getValue().getAddress());
		ui.setCity(getValue().getCity());
	}
	
}
