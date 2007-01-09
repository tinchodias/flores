package model.money;

public class Cash implements Pay {

	private final Pesos value;

	public Cash(Pesos value) {
		this.value = value;
	}

	public Pesos getValue() {
		return value;
	}

}
