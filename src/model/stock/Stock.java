package model.stock;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import model.money.Pesos;
import model.receipt.Buy;
import model.receipt.BuyAnnulment;
import model.receipt.Sell;
import model.receipt.SellAnnulment;


public class Stock {

	private Map<Article, Double> stockArticles = new HashMap<Article, Double>();
	private CostStrategy costValuation;
	private Collection<StockDropOut> dropOuts = new LinkedList<StockDropOut>();
	
	public Stock() {
		costValuation = new AverageCostStrategy(this);
	}
	
	public Double count(Article article) {
		Double count = stockArticles.get(article);
		return count != null ? count : 0.0;
	}

	public Pesos cost(Article article) {
		return costValuation.cost(article);
	}

	public CostStrategy getCostValuation() {
		return costValuation;
	}

	public void setCostValuation(CostStrategy costValuation) {
		this.costValuation = costValuation;
	}

	public void apply(Buy buy) {
		costValuation.notify(buy);
		for (Article article : buy.items().getArticles()) {
			Double boughtCount = buy.items().getCount(article);
			addToStock(article, boughtCount);
		}
	}

	public void apply(Sell sell) {
		costValuation.notify(sell);
		for (Article article : sell.items().getArticles()) {
			Double soldCount = sell.items().getCount(article);
			removeFromStock(article, soldCount);
		}
	}

	public void apply(BuyAnnulment annulment) {
		costValuation.notify(annulment);
		Buy buy = annulment.getBuy();
		for (Article article : buy.items().getArticles()) {
			Double boughtCount = buy.items().getCount(article);
			removeFromStock(article, boughtCount);
		}
	}

	public void apply(SellAnnulment annulment) {
		costValuation.notify(annulment);
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

		costValuation.notify(dropOut);
		removeFromStock(dropOut.getArticle(), dropOut.getCount());
	}

	public Collection<StockDropOut> dropOuts() {
		return Collections.unmodifiableCollection(dropOuts);
	}

}
