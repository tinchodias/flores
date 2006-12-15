package money;

public class Check implements Pay {

	private final Pesos value;

	public Check(Pesos value, String serialNumber) {
		this.value = value;
	}

	public Pesos getValue() {
		return value;
	}
	
}
