package ui.view.component;

import model.money.MoneyAmount;
import model.stock.Article;
import ui.controller.action.Action;
import ui.controller.initializer.search.SearchDialogInitializer;

public interface SellItemUI extends DetailUI {

	Article getArticle();
	
	double getCount();
	
	MoneyAmount getValue();
	
	void setCount(double count);
	
	void setValue(double value);
	
	void setArticleSearchInitializer(SearchDialogInitializer initializer);

	void addOnArticleSelectionAction(Action action);
	
	void setCost(String cost);
	
}
