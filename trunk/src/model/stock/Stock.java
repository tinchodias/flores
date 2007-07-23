package model.stock;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import model.money.Pesos;
import model.receipt.Buy;
import model.receipt.BuyAnnulment;
import model.receipt.Sell;
import model.receipt.SellAnnulment;
import model.stock.cost.CostStrategy;
import model.stock.cost.LastPrevailsCostStrategy;
import model.util.CollectionFactory;

public class Stock {

	private Map<Article, Double> stockArticles = CollectionFactory.<Article, Double>newMap();
	private CostStrategy costStrategy;
	private Collection<StockDropOut> dropOuts = CollectionFactory.<StockDropOut>newList();
	
	public Stock() {
//		costStrategy = new AverageCostStrategy(this);
		costStrategy = new LastPrevailsCostStrategy(this);
	}
	
	public Double count(Article article) {
		Double count = stockArticles.get(article);
		return count != null ? count : 0.0;
	}

	public Pesos cost(Article article) {
		return costStrategy.cost(article);
	}

	public CostStrategy getCostStrategy() {
		return costStrategy;
	}

	public void setCostStrategy(CostStrategy costValuation) {
		this.costStrategy = costValuation;
	}

	public void apply(Buy buy) {
		costStrategy.notify(buy);
		for (Article article : buy.items().getArticles()) {
			Double boughtCount = buy.items().getCount(article);
			addToStock(article, boughtCount);
		}
	}

	public void apply(Sell sell) {
		costStrategy.notify(sell);
		for (Article article : sell.items().getArticles()) {
			Double soldCount = sell.items().getCount(article);
			removeFromStock(article, soldCount);
		}
	}

	public void apply(BuyAnnulment annulment) {
		costStrategy.notify(annulment);
		Buy buy = annulment.getBuy();
		for (Article article : buy.items().getArticles()) {
			Double boughtCount = buy.items().getCount(article);
			removeFromStock(article, boughtCount);
		}
	}

	public void apply(SellAnnulment annulment) {
		costStrategy.notify(annulment);
		Sell sell = annulment.getSell();
		for (Article article : sell.items().getArticles()) {
			Double soldCount = sell.items().getCount(article);
			addToStock(article, soldCount);
		}
	}

	private void addToStock(Article article, Double count) {
		Double actualCount = this.count(article);
		stockArticles.put(article, actualCount + count);
	}

	private void removeFromStock(Article article, Double count) {
		addToStock(article, -count);
	}

	public void add(StockDropOut dropOut) {
		dropOuts.add(dropOut);

		costStrategy.notify(dropOut);
		removeFromStock(dropOut.getArticle(), dropOut.getCount());
	}

	public Collection<StockDropOut> dropOuts() {
		return Collections.unmodifiableCollection(dropOuts);
	}

}
