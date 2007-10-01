package model.expense;

import message.MessageId;
import model.money.MoneyAmount;

import org.joda.time.base.BaseDateTime;

import validation.ModelValidation;

public class Expense {

	private final ExpenseArticle article;
	private final MoneyAmount cost;
	private final BaseDateTime date;

	public Expense(ExpenseArticle article, MoneyAmount cost, BaseDateTime date) {
		ModelValidation.instance().assertNotNull(article, MessageId.article);
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
