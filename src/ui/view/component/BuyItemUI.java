package ui.view.component;

import model.money.Pesos;
import model.stock.Article;
import ui.controller.initializer.search.SearchDialogInitializer;

public interface BuyItemUI extends DetailUI {

	public Article getArticle();
	
	public double getCount();
	
	public Pesos getValue();
	
	public void setArticleSearchInitializer(SearchDialogInitializer initializer);

}
