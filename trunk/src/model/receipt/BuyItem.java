package model.receipt;

import model.money.Pesos;
import model.stock.Article;

public class BuyItem {
	private double count;
	private Pesos value;
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

	public void setValue(Pesos value) {
		this.value = value;
	}
	
}