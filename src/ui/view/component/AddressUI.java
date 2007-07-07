package ui.view.component;

import ui.controller.initializer.search.SearchDialogInitializer;
import model.address.City;

public interface AddressUI {

	public String getAddress();
	
	public City getCity();
	
	public void setCitySearchInitializer(SearchDialogInitializer initializer);
	
}
