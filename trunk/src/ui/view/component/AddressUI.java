package ui.view.component;

import ui.controller.initializer.search.SearchDialogInitializer;
import model.address.City;

public interface AddressUI {

	public String getAddress();
	
	public City getCity();
	
	public void setAddress(String address);
	
	public void setCity(City city);
	
	public void setCitySearchInitializer(SearchDialogInitializer initializer);
	
}
