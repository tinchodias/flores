package query.results;


import message.MessageId;
import model.expense.Expense;
import query.framework.results.LazySearchResultsSpecification;

public class ExpenseSearchResultsSpecification extends LazySearchResultsSpecification {

	public ExpenseSearchResultsSpecification() {
		add(MessageId.date);
		add(MessageId.expenseArticle);
		add(MessageId.cashPay);
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
