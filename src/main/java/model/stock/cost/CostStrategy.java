package model.stock.cost;

import model.money.MoneyAmount;
import model.receipt.Buy;
import model.receipt.BuyCancellation;
import model.receipt.Sell;
import model.receipt.SellCancellation;
import model.stock.Article;
import model.stock.Stock;
import model.stock.StockDropOut;

public interface CostStrategy {

	MoneyAmount cost(Article article);

	void setStock(Stock stock);

	void notify(Buy buy);

	void notify(Sell sell);

	void notify(BuyCancellation cancellation);

	void notify(SellCancellation cancellation);

	void notify(StockDropOut dropOut);

}
