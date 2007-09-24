package query.results;


import message.MessageId;
import model.expense.Expense;
import model.money.MoneyAmount;

import org.joda.time.ReadableInstant;

import query.framework.results.LazySearchResultsSpecification;

public class ExpenseSearchResultsSpecification extends LazySearchResultsSpecification {

	public ExpenseSearchResultsSpecification() {
		add(MessageId.date, ReadableInstant.class);
		add(MessageId.expenseArticle);
		add(MessageId.cashPay, MoneyAmount.class);
	}
	
	public Object value(Object object, int columnIndex) {
		Expense expense = (Expense) object;
		switch (columnIndex) {
		case 0:
			return expense.getDate();
		case 1:
			return expense.getArticle().toString();
		case 2:
			return expense.getCost();
		}
		return null;
	}

}
