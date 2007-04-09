package model.money;

public class Check implements PayMode {

	private final Pesos value;

	public Check(Pesos value, String serialNumber) {
		this.value = value;
	}

	public Pesos getValue() {
		return value;
	}
	
}
