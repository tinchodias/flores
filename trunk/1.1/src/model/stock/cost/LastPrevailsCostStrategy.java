package model.stock.cost;

import java.util.Map;

import model.money.MoneyAmount;
import model.receipt.Buy;
import model.receipt.BuyCancellation;
import model.receipt.BuyItem;
import model.receipt.Sell;
import model.receipt.SellCancellation;
import model.stock.Article;
import model.stock.Stock;
import model.stock.StockDropOut;
import model.util.CollectionFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class LastPrevailsCostStrategy implements CostStrategy {

	private Map<Article, MoneyAmount> costs = CollectionFactory.newIdentityMap();
	private Stock stock;
	
	public LastPrevailsCostStrategy(Stock stock) {
		this.stock = stock;
	}

	public MoneyAmount cost(Article article) {
		MoneyAmount moneyAmount = costs.get(article);
		return moneyAmount != null ? moneyAmount : MoneyAmount.zero();
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public void notify(Buy buy) {
		for (BuyItem item : buy.items()) {
			costs.put(item.getArticle(), item.getValue());
		}
	}

	public void notify(BuyCancellation cancellation) {
		//TODO if its the last buy, it must get the previous costs.
		throw new NotImplementedException();
	}

	public void notify(Sell sell) {
		//Do nothing on Sell
	}

	public void notify(SellCancellation cancellation) {
		//Do nothing on SellCancellation
	}

	public void notify(StockDropOut dropOut) {
		//Do nothing on StockDropOut
	}

}
