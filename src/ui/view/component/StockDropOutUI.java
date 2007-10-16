package ui.view.component;

import model.stock.Article;
import ui.controller.manager.UIModelManager;

public interface StockDropOutUI extends DetailUI {

	double getCount();

	Article getArticle();

	String getNote();

	void setArticleManager(UIModelManager manager);
	
}