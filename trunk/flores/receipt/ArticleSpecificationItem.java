package model.receipt;

import model.money.Pesos;

public class ArticleSpecificationItem {
	private final double count;
	private final Pesos pesos;

	public ArticleSpecificationItem(double count, Pesos pesos) {
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