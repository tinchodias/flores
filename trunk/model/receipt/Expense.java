package model.receipt;

import java.util.Date;

import model.money.Pesos;
import model.stock.Article;

public class Expense {

	private final Article article;
	private final Pesos cost;
	private final Date date;

	public Expense(Article article, Pesos cost, Date date) {
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

	public Date getDate() {
		return date;
	}
}
