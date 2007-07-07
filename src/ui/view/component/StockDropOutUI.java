package ui.view.component;

import ui.controller.initializer.search.SearchDialogInitializer;
import model.stock.Article;

public interface StockDropOutUI extends DetailUI {

	public double getCount();

	public Article getArticle();

	public void setArticleSearchInitializer(SearchDialogInitializer initializer);
	
}