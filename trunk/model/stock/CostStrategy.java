package model.stock;

import model.money.Pesos;
import model.receipt.Buy;
import model.receipt.BuyAnnulment;
import model.receipt.Sell;
import model.receipt.SellAnnulment;

public interface CostStrategy {

	Pesos cost(Article article);

	void setStock(Stock stock);

	void notify(Buy buy);

	void notify(Sell sell);

	void notify(BuyAnnulment annulment);

	void notify(SellAnnulment annulment);

	void notify(StockDropOut dropOut);

}
