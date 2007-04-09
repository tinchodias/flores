package model.receipt;

import model.money.Pesos;
import model.stock.Article;

import org.joda.time.ReadableDateTime;

public class Expense {

	private final Article article;
	private final Pesos cost;
	private final ReadableDateTime date;

	public Expense(Article article, Pesos cost, ReadableDateTime date) {
		this.article = article;
		this.cost = cost;
		this.date = date;
	}

	public Article getArticle() {
		return article;
	}

	public Pesos getCost() {
		return cost;
	}

	public ReadableDateTime getDate() {
		return date;
	}
}
