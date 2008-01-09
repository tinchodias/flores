package ui.controller.populator;

import model.address.City;
import persistence.ModelPersistence;
import ui.view.component.CityUI;

public class CityPopulator implements DetailPopulator<City, CityUI> {

	public City createFrom(CityUI ui) {
		City city = new City(ui.getCityName(), ui.getProvince());

		ModelPersistence.instance().loadedModel().store().cities().add(city);
		return city;
	}

	public void modifyFrom(CityUI ui, City object) {
		object.setName(ui.getCityName());
		object.setProvince(ui.getProvince());
	}

	public void showIn(CityUI ui, City object) {
		ui.setCityName(object.getName());
		ui.setProvince(object.getProvince());
	}
	
}
