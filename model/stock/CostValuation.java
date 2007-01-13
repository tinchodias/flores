package model.stock;

import model.Article;
import model.money.Pesos;
import model.receipt.Buy;
import model.receipt.Sell;

public interface CostValuation {

	Pesos cost(Article article);

	void notify(Buy buy);

	void notify(Sell sell);

	void setStock(Stock stock);

}
