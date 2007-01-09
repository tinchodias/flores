package model.stock;

import java.util.HashMap;
import java.util.Map;


import model.Article;
import model.money.Pesos;
import model.receipt.Buy;
import model.receipt.Sell;

public class AverageCostValuation implements CostValuation {

	private Map<Article, Pesos> costs = new HashMap();
	private final Stock stock;
	
	public AverageCostValuation(Stock stock) {
		this.stock = stock;
	}

	public Pesos cost(Article article) {
		Pesos pesos = costs.get(article);
		return pesos != null ? pesos : Pesos.newFor(0.0);
	}

	public void notify(Buy buy) {
		for (Article article : buy.specification().getArticles()) {
			Double inputCount = buy.specification().getCount(article);
			Pesos inputCost = buy.specification().getPesos(article);
			notifyArticleInput(article, inputCount, inputCost);
		}
	}

	public void notify(Sell sell) {
		//Do nothing on Sell
	}

	private void notifyArticleInput(Article article, Double inputCount, Pesos inputCost) {
		Pesos actualCost = stock.cost(article);
		Double actualCount = stock.count(article);
		
		Double newCostValue = 
			(actualCount * actualCost.value() + inputCount * inputCost.value()) 
			/ (actualCount + inputCount);
		
		costs.put(article, Pesos.newFor(newCostValue));
	}

}
