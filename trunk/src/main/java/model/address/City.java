package model.address;

public class City {

	private String name;
	private Province province;

	public City(String name, Province province) {
		this.name = name;
		this.province = province;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Province getProvince() {
		return province;
	}
	
	public void setProvince(Province province) {
		this.province = province;
	}
	
	public String toString() {
		return getName(); 
	}
	
}
