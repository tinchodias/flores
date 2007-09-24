package model.money;

public class Check implements PayMode {

	private final MoneyAmount value;

	public Check(MoneyAmount value, String serialNumber) {
		this.value = value;
	}

	public MoneyAmount getValue() {
		return value;
	}
	
}
