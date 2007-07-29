package model.price;

import model.money.Pesos;
import model.stock.Article;

public interface PriceStrategy {

	Pesos priceFor(Article article);

}
