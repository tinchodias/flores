package model.price;

import model.money.MoneyAmount;
import model.stock.Article;

public interface PriceStrategy {

	MoneyAmount priceFor(Article article);

}
