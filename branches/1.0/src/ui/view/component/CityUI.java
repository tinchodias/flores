package ui.view.component;

import model.address.Province;
import ui.controller.manager.UIModelManager;

public interface CityUI extends DetailUI {

	String getCityName();

	void setCityName(String name);
	
	Province getProvince();

	void setProvince(Province province);
	
	void setProvinceManager(UIModelManager manager);
	
}