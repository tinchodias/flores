package model.receipt;

import model.money.Pesos;
import model.stock.Article;

public class BuyItem {
	private final double count;
	private final Pesos value;
	private final Article article;

	public BuyItem(Article article, double count, Pesos value) {
		this.article = article;
		this.count = count;
		this.value = value;
	}

	public double getCount() {
		return count;
	}

	public Pesos getValue() {
		return value;
	}

	public Article getArticle() {
		return article;
	}
	
}