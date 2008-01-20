package ui.controller.populator;

import model.Store;
import model.expense.ExpenseArticle;
import persistence.ModelPersistence;
import ui.view.component.ExpenseArticleUI;

public class ExpenseArticlePopulator implements DetailPopulator<ExpenseArticle, ExpenseArticleUI>{

	public ExpenseArticle createFrom(ExpenseArticleUI ui) {
		ExpenseArticle article = new ExpenseArticle(ui.getArticleName());
		
		Store store = ModelPersistence.instance().loadedModel().store();
		store.expensesArticles().add(article);
		return article;
	}

	public void modifyFrom(ExpenseArticleUI ui, ExpenseArticle object) {
		object.setName(ui.getArticleName());
	}

	public void showIn(ExpenseArticleUI ui, ExpenseArticle object) {
		ui.setArticleName(object.getName());
	}

}
