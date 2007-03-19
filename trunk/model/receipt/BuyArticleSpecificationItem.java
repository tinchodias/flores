package model.receipt;

import model.money.Pesos;

public class BuyArticleSpecificationItem {
	private final double count;
	private final Pesos pesos;

	public BuyArticleSpecificationItem(double count, Pesos pesos) {
		this.count = count;
		this.pesos = pesos;
	}

	public double getCount() {
		return count;
	}

	public Pesos getPesos() {
		return pesos;
	}
}