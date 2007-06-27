package ui.controller.action;

import message.MessageId;
import model.Store;
import model.stock.Article;
import model.stock.ArticleGroup;
import persistence.ModelPersistence;
import ui.view.component.ArticleUI;

public class CreateArticleAction implements Action {

	private final ArticleUI articleUI;

	public CreateArticleAction(ArticleUI articleUI) {
		this.articleUI = articleUI;
	}

	public void execute() {
		Article article = article();
		Store store = ModelPersistence.instance().loadedModel().store();
		store.stockArticles().add(article);
		
		articleUI.setVisible(false);
	}

	private Article article() {
		String name = articleUI.getArticleName();
		ArticleGroup group = articleUI.getArticleGroup();
		return new Article(name, group);
	}

	public MessageId messageId() {
		return MessageId.accept;
	}

}
