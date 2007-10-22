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

public class AverageCostStrategy implements CostStrategy {

	private Map<Article, MoneyAmount> costs = CollectionFactory.newIdentityMap();
	private Stock stock;
	
	public AverageCostStrategy(Stock stock) {
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
			applyArticleMovement(item.getArticle(), item.getCount(), item.getValue());
		}
	}

	public void notify(BuyCancellation cancellation) {
		Buy buy = cancellation.getBuy();
		for (BuyItem item : buy.items()) {
			applyArticleMovement(item.getArticle(), -item.getCount(), item.getValue());
		}
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

	private void applyArticleMovement(Article article, Double inputCount, MoneyAmount inputCost) {
		MoneyAmount actualCost = stock.cost(article);
		Double actualCount = stock.count(article);
		
		Double newCostValue = 
			(actualCount * actualCost.value() + inputCount * inputCost.value()) 
			/ (actualCount + inputCount);
		
		costs.put(article, MoneyAmount.newFor(newCostValue));
	}
}
