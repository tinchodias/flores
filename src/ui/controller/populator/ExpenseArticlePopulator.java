package ui.controller.populator;

import model.Store;
import model.expense.ExpenseArticle;
import persistence.ModelPersistence;
import ui.view.component.ExpenseArticleUI;

public class ExpenseArticlePopulator extends DetailPopulator<ExpenseArticle, ExpenseArticleUI>{

	public void createFrom(ExpenseArticleUI ui) {
		ExpenseArticle article = new ExpenseArticle(ui.getArticleName());
		
		Store store = ModelPersistence.instance().loadedModel().store();
		store.expensesArticles().add(article);
	}

	public void modifyFrom(ExpenseArticleUI ui) {
		getValue().setName(ui.getArticleName());
	}

	public void showIn(ExpenseArticleUI ui) {
		ui.setArticleName(getValue().getName());
	}

}
