package ui.view.component;

import model.expense.ExpenseArticle;
import model.money.MoneyAmount;
import ui.controller.manager.UIModelManager;


public interface ExpenseUI extends DetailUI {

	ExpenseArticle getExpenseArticle();

	MoneyAmount getCost();
	
	void setExpenseArticleManager(UIModelManager manager);
	
}
