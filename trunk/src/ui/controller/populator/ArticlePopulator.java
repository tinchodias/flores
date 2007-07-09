package ui.controller.populator;

import model.Store;
import model.stock.Article;
import persistence.ModelPersistence;
import ui.view.component.ArticleUI;

public class ArticlePopulator extends DetailPopulator<Article, ArticleUI>{

	public void createFrom(ArticleUI ui) {
		Article article = new Article(ui.getCode(), ui.getArticleName(), 
				ui.getArticleSize(), ui.getArticleGroup());
		
		Store store = ModelPersistence.instance().loadedModel().store();
		store.stockArticles().add(article);
	}

	public void modifyFrom(ArticleUI ui) {
		getValue().setCode(ui.getCode());
		getValue().setName(ui.getArticleName());
		getValue().setSize(ui.getArticleSize());
		getValue().setGroup(ui.getArticleGroup());
	}

	public void showIn(ArticleUI ui) {
		ui.setCode(getValue().getCode());
		ui.setArticleName(getValue().getName());
		ui.setArticleSize(getValue().getSize());
		ui.setArticleGroup(getValue().getGroup());
	}

}
