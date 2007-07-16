package model.receipt;

import model.money.Pesos;
import model.stock.Article;

public class BuyItem {
	private double count;
	private Pesos value;
	private final Article article;
	private final double priceMargin;

	public BuyItem(Article article, double count, Pesos value) {
		this(article, count, value, 0);
	}
	public BuyItem(Article article, double count, Pesos value, double margin) {
		this.article = article;
		this.count = count;
		this.value = value;
		this.priceMargin = margin;
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

	public void setValue(Pesos value) {
		this.value = value;
	}
	
	public double getPriceMargin() {
		return priceMargin;
	}
	
}