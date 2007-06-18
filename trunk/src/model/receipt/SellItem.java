package model.receipt;

import model.money.Pesos;

public class SellItem {
	private final double count;
	private final Pesos sellValue;
	private final Pesos costValue;

	public SellItem(double count, Pesos sellValue, Pesos costValue) {
		this.count = count;
		this.sellValue = sellValue;
		this.costValue = costValue;
	}

	public double getCount() {
		return count;
	}

	public Pesos getCostValue() {
		return costValue;
	}

	public Pesos getSellValue() {
		return sellValue;
	}
}