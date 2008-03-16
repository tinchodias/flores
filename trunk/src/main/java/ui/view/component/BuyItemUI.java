package ui.view.component;

import model.money.MoneyAmount;
import model.stock.Article;
import ui.controller.manager.UIModelManager;

public interface BuyItemUI extends DetailUI {

	Article getArticle();
	
	double getCount();
	
	MoneyAmount getValue();
	
	void setArticleManager(UIModelManager manager);

}
