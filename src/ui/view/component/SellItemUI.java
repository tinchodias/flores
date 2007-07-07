package ui.view.component;

import model.money.Pesos;
import model.stock.Article;
import ui.controller.action.Action;
import ui.controller.initializer.search.SearchDialogInitializer;

public interface SellItemUI extends DetailUI {

	public Article getArticle();
	
	public double getCount();
	
	public Pesos getValue();
	
	public void setArticleSearchInitializer(SearchDialogInitializer initializer);

	public void setCostAction(Action action);
	
	public void setCost(String cost);
	
}
