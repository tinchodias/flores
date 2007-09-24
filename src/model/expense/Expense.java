package model.expense;

import model.money.MoneyAmount;

import org.joda.time.base.BaseDateTime;

public class Expense {

	private final ExpenseArticle article;
	private final MoneyAmount cost;
	private final BaseDateTime date;

	public Expense(ExpenseArticle article, MoneyAmount cost, BaseDateTime date) {
		this.article = article;
		this.cost = cost;
		this.date = date;
	}

	public ExpenseArticle getArticle() {
		return article;
	}

	public MoneyAmount getCost() {
		return cost;
	}

	public BaseDateTime getDate() {
		return date;
	}
}
