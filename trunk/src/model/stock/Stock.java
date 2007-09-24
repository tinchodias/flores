package model.stock;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import model.money.MoneyAmount;
import model.receipt.Buy;
import model.receipt.BuyCancellation;
import model.receipt.BuyItem;
import model.receipt.Sell;
import model.receipt.SellCancellation;
import model.receipt.SellItem;
import model.stock.cost.AverageCostStrategy;
import model.stock.cost.CostStrategy;
import model.util.CollectionFactory;

public class Stock {

	private Map<Article, Double> stockArticles = CollectionFactory.<Article, Double>newIdentityMap();
	private CostStrategy costStrategy;
	private Collection<StockDropOut> dropOuts = CollectionFactory.<StockDropOut>newList();
	
	public Stock() {
		costStrategy = new AverageCostStrategy(this);
//		costStrategy = new LastPrevailsCostStrategy(this);
	}
	
	public Double count(Article article) {
		Double count = stockArticles.get(article);
		return count != null ? count : 0.0;
	}

	public MoneyAmount cost(Article article) {
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
		for (BuyItem item : buy.items()) {
			addToStock(item.getArticle(), item.getCount());
		}
	}

	public void apply(Sell sell) {
		costStrategy.notify(sell);
		for (SellItem item : sell.items()) {
			removeFromStock(item.getArticle(), item.getCount());
		}
	}

	public void apply(BuyCancellation cancellation) {
		costStrategy.notify(cancellation);
		Buy buy = cancellation.getBuy();
		for (BuyItem item : buy.items()) {
			removeFromStock(item.getArticle(), item.getCount());
		}
	}

	public void apply(SellCancellation cancellation) {
		costStrategy.notify(cancellation);
		Sell sell = cancellation.getSell();
		for (SellItem item : sell.items()) {
			addToStock(item.getArticle(), item.getCount());
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
