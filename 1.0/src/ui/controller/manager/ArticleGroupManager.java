package ui.controller.manager;

import message.MessageId;
import ui.controller.initializer.search.ArticleGroupsDialogInitializer;

public class ArticleGroupManager extends StandardUIModelManager {

	public ArticleGroupManager() {
		super(new ArticleGroupsDialogInitializer(), store().stockArticleGroups(), MessageId.articleGroup);
	}
	
}
