package model.expense;

import model.money.Pesos;

import org.joda.time.ReadableDateTime;

public class Expense {

	private final ExpenseArticle article;
	private final Pesos cost;
	private final ReadableDateTime date;

	public Expense(ExpenseArticle article, Pesos cost, ReadableDateTime date) {
		this.article = article;
		this.cost = cost;
		this.date = date;
	}

	public ExpenseArticle getArticle() {
		return article;
	}

	public Pesos getCost() {
		return cost;
	}

	public ReadableDateTime getDate() {
		return date;
	}
}
