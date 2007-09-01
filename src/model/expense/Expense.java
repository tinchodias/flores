package model.expense;

import model.money.Pesos;

import org.joda.time.base.BaseDateTime;

public class Expense {

	private final ExpenseArticle article;
	private final Pesos cost;
	private final BaseDateTime date;

	public Expense(ExpenseArticle article, Pesos cost, BaseDateTime date) {
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

	public BaseDateTime getDate() {
		return date;
	}
}
