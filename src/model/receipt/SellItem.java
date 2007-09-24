package model.receipt;

import model.money.MoneyAmount;
import model.stock.Article;

public class SellItem {
	private final double count;
	private MoneyAmount sellValue;
	private final MoneyAmount costValue;
	private final Article article;

	public SellItem(Article article, double count, MoneyAmount sellValue, MoneyAmount costValue) {
		this.article = article;
		this.count = count;
		this.sellValue = sellValue;
		this.costValue = costValue;
	}

	public double getCount() {
		return count;
	}

	public MoneyAmount getCostValue() {
		return costValue;
	}

	public MoneyAmount getSellValue() {
		return sellValue;
	}

	public Article getArticle() {
		return article;
	}

	public void setSellValue(MoneyAmount sellValue) {
		this.sellValue = sellValue;
	}
}