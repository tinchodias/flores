package model.stock;

import java.util.HashMap;
import java.util.Map;

import model.money.Pesos;
import model.receipt.Buy;
import model.receipt.BuyAnnulment;
import model.receipt.Sell;
import model.receipt.SellAnnulment;

public class AverageCostStrategy implements CostStrategy {

	private Map<Article, Pesos> costs = new HashMap<Article, Pesos>();
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

	public void notify(BuyAnnulment annulment) {
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

	public void notify(SellAnnulment annulment) {
		//Do nothing on SellAnnulment
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
