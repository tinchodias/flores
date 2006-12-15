package flores.stock;

import flores.Article;
import flores.receipt.Buy;
import flores.receipt.Sell;
import money.Pesos;

public interface CostValuation {

	Pesos cost(Article article);

	void notify(Buy buy);

	void notify(Sell sell);

}
