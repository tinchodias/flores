package ui.controller.populator;

import persistence.ModelPersistence;
import ui.view.component.ArticleGroupUI;
import model.stock.ArticleGroup;

public class ArticleGroupPopulator extends DetailPopulator<ArticleGroup, ArticleGroupUI> {

	public void createFrom(ArticleGroupUI ui) {
		ArticleGroup group = new ArticleGroup(ui.getArticleGroupName());
		
		ModelPersistence.instance().loadedModel().store().stockArticleGroups().add(group);
	}

	public void modifyFrom(ArticleGroupUI ui) {
		getValue().setName(ui.getArticleGroupName());
	}

	public void showIn(ArticleGroupUI ui) {
		ui.setArticleGroupName(getValue().getName());
	}
}
