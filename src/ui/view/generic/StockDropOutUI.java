package ui.view.component;

import model.stock.Article;

public interface StockDropOutUI extends DetailUI {

	public abstract double getCount();

	public abstract Article getArticle();

}