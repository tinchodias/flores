package model.receipt;

import model.money.MoneyAmount;
import model.stock.Article;

public class BuyItem {
	private double count;
	private MoneyAmount value;
	private final Article article;

	public BuyItem(Article article, double count, MoneyAmount value) {
		this.article = article;
		this.count = count;
		this.value = value;
	}

	public double getCount() {
		return count;
	}

	public MoneyAmount getValue() {
		return value;
	}

	public Article getArticle() {
		return article;
	}

	public void setValue(MoneyAmount value) {
		this.value = value;
	}
	
}