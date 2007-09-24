package model.money;

public class Cash implements PayMode {

	private final MoneyAmount value;

	public Cash(MoneyAmount value) {
		this.value = value;
	}

	public MoneyAmount getValue() {
		return value;
	}

}
