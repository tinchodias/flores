package ui.view.component;

import ui.controller.initializer.search.SearchDialogInitializer;
import model.expense.ExpenseArticle;
import model.money.MoneyAmount;


public interface ExpenseUI extends DetailUI {

	ExpenseArticle getExpenseArticle();

	MoneyAmount getCost();
	
	void setExpenseArticleSearchInitializer(SearchDialogInitializer initializer);
	
}
