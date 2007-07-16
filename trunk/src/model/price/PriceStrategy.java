package model.price;

import model.money.Pesos;
import model.receipt.Buy;
import model.receipt.BuyAnnulment;
import model.stock.Article;

public interface PriceStrategy {

	Pesos priceFor(Article article);

	void apply(Buy buy);

	void apply(BuyAnnulment annulment);
	
}
