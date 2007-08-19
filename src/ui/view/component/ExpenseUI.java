package ui.view.component;

import ui.controller.initializer.search.SearchDialogInitializer;
import model.expense.ExpenseArticle;
import model.money.Pesos;


public interface ExpenseUI extends DetailUI {

	ExpenseArticle getExpenseArticle();

	Pesos getCost();
	
	void setExpenseArticleSearchInitializer(SearchDialogInitializer initializer);
	
}
