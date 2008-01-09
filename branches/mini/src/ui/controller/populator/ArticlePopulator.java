package ui.controller.populator;

import model.Store;
import model.stock.Article;
import persistence.ModelPersistence;
import ui.view.component.ArticleUI;

public class ArticlePopulator implements DetailPopulator<Article, ArticleUI>{

	public Article createFrom(ArticleUI ui) {
		Article article = new Article(ui.getCode(), ui.getArticleName(), 
				ui.getArticleSize(), ui.getArticleGroup());
		
		Store store = ModelPersistence.instance().loadedModel().store();
		store.stockArticles().add(article);
		return article;
	}

	public void modifyFrom(ArticleUI ui, Article object) {
		object.setCode(ui.getCode());
		object.setName(ui.getArticleName());
		object.setSize(ui.getArticleSize());
		object.setGroup(ui.getArticleGroup());
	}

	public void showIn(ArticleUI ui, Article object) {
		ui.setCode(object.getCode());
		ui.setArticleName(object.getName());
		ui.setArticleSize(object.getSize());
		ui.setArticleGroup(object.getGroup());
	}

}
