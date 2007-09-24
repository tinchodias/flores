package ui.view.component;

import model.money.MoneyAmount;
import model.stock.Article;
import ui.controller.initializer.search.SearchDialogInitializer;

public interface BuyItemUI extends DetailUI {

	public Article getArticle();
	
	public double getCount();
	
	public MoneyAmount getValue();
	
	public void setArticleSearchInitializer(SearchDialogInitializer initializer);

}
