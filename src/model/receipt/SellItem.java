package model.receipt;

import model.money.Pesos;
import model.stock.Article;

public class SellItem {
	private final double count;
	private Pesos sellValue;
	private final Pesos costValue;
	private final Article article;

	public SellItem(Article article, double count, Pesos sellValue, Pesos costValue) {
		this.article = article;
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

	public Article getArticle() {
		return article;
	}

	public void setSellValue(Pesos sellValue) {
		this.sellValue = sellValue;
	}
}