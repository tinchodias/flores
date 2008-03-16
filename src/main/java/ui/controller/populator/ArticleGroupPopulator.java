package ui.controller.populator;

import persistence.ModelPersistence;
import ui.view.component.ArticleGroupUI;
import model.stock.ArticleGroup;

public class ArticleGroupPopulator implements DetailPopulator<ArticleGroup, ArticleGroupUI> {

	public ArticleGroup createFrom(ArticleGroupUI ui) {
		ArticleGroup group = new ArticleGroup(ui.getArticleGroupName());
		
		ModelPersistence.instance().loadedModel().store().stockArticleGroups().add(group);
		return group;
	}

	public void modifyFrom(ArticleGroupUI ui, ArticleGroup object) {
		object.setName(ui.getArticleGroupName());
	}

	public void showIn(ArticleGroupUI ui, ArticleGroup object) {
		ui.setArticleGroupName(object.getName());
	}
}
