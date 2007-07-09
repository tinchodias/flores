package ui.view.component;

import ui.controller.initializer.search.SearchDialogInitializer;
import model.stock.ArticleGroup;

public interface ArticleUI extends DetailUI {

	String getCode();

	String getArticleName();

	String getArticleSize();
	
	ArticleGroup getArticleGroup();
	
	void setCode(String code);
	
	void setArticleName(String name);

	void setArticleSize(String size);

	void setArticleGroup(ArticleGroup articleGroup);

	
	void setArticleGroupSearchInitializer(SearchDialogInitializer initializer);
	
}
