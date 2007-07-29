package model.stock.cost;

import java.util.Map;

import model.money.Pesos;
import model.receipt.Buy;
import model.receipt.BuyCancellation;
import model.receipt.Sell;
import model.receipt.SellCancellation;
import model.stock.Article;
import model.stock.Stock;
import model.stock.StockDropOut;
import model.util.CollectionFactory;

public class AverageCostStrategy implements CostStrategy {

	private Map<Article, Pesos> costs = CollectionFactory.newMap();
	private Stock stock;
	
	public AverageCostStrategy(Stock stock) {
		this.stock = stock;
	}

	public Pesos cost(Article article) {
		Pesos pesos = costs.get(article);
		return pesos != null ? pesos : Pesos.newFor(0.0);
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public void notify(Buy buy) {
		for (Article article : buy.items().getArticles()) {
			Double inputCount = buy.items().getCount(article);
			Pesos inputCost = buy.items().getValue(article);
			applyArticleMovement(article, inputCount, inputCost);
		}
	}

	public void notify(BuyCancellation annulment) {
		Buy buy = annulment.getBuy();
		for (Article article : buy.items().getArticles()) {
			Double inputCount = buy.items().getCount(article);
			Pesos inputCost = buy.items().getValue(article);
			applyArticleMovement(article, -inputCount, inputCost);
		}
	}

	public void notify(Sell sell) {
		//Do nothing on Sell
	}

	public void notify(SellCancellation annulment) {
		//Do nothing on SellCancellation
	}

	public void notify(StockDropOut dropOut) {
		//Do nothing on StockDropOut
	}

	private void applyArticleMovement(Article article, Double inputCount, Pesos inputCost) {
		Pesos actualCost = stock.cost(article);
		Double actualCount = stock.count(article);
		
		Double newCostValue = 
			(actualCount * actualCost.value() + inputCount * inputCost.value()) 
			/ (actualCount + inputCount);
		
		costs.put(article, Pesos.newFor(newCostValue));
	}
}
