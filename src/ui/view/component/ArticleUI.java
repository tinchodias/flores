package ui.view.component;

import ui.controller.initializer.search.SearchDialogInitializer;
import model.stock.ArticleGroup;

public interface ArticleUI extends DetailUI {

	public String getArticleName();
	
	public ArticleGroup getArticleGroup();
	
	public void setArticleGroupSearchInitializer(SearchDialogInitializer initializer);
	
}
