package ui.view.component;

import model.stock.Article;
import ui.controller.manager.UIModelManager;

public interface StockDropOutUI extends DetailUI {

	double getCount();

	Article getArticle();

	void setArticleManager(UIModelManager manager);
	
}