package ui.view.component;

import model.address.City;
import ui.controller.manager.UIModelManager;

public interface AddressUI {

	public String getAddress();
	
	public City getCity();
	
	public void setAddress(String address);
	
	public void setCity(City city);
	
	public void setCityManager(UIModelManager manager);
	
}
