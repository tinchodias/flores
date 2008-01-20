package ui.view.component;

import model.money.MoneyAmount;
import model.stock.Article;
import ui.controller.action.Action;
import ui.controller.manager.UIModelManager;

public interface SellItemUI extends DetailUI {

	Article getArticle();
	
	double getCount();
	
	MoneyAmount getValue();
	
	void setCount(double count);
	
	void setValue(double value);
	
	void setArticleManager(UIModelManager manager);

	void addOnArticleSelectionAction(Action action);
	
	void setCost(String cost);
	
	void setStockCount(String count);
	
}
