package model.stock;

import java.util.HashMap;
import java.util.Map;

import model.Article;
import model.money.Pesos;
import model.receipt.Buy;
import model.receipt.BuyAnnulment;
import model.receipt.Sell;
import model.receipt.SellAnnulment;


public class Stock {

	private Map<Article, Double> stockArticles = new HashMap();
	private CostValuation costValuation;
	
	public Stock() {
		costValuation = new AverageCostValuation(this);
	}
	
	public Double count(Article article) {
		Double count = stockArticles.get(article);
		return count != null ? count : 0.0;
	}

	public Pesos cost(Article article) {
		return costValuation.cost(article);
	}

	public CostValuation getCostValuation() {
		return costValuation;
	}

	public void setCostValuation(CostValuation costValuation) {
		this.costValuation = costValuation;
	}

	public void apply(Buy buy) {
		costValuation.notify(buy);
		for (Article article : buy.specification().getArticles()) {
			Double actualCount = this.count(article);
			Double boughtCount = buy.specification().getCount(article);
			stockArticles.put(article, actualCount + boughtCount);
		}
	}

	public void apply(Sell sell) {
		costValuation.notify(sell);
		for (Article article : sell.specification().getArticles()) {
			Double actualCount = this.count(article);
			Double soldCount = sell.specification().getCount(article);
			stockArticles.put(article, actualCount - soldCount);
		}
	}

	public void apply(BuyAnnulment annulment) {
		costValuation.notify(annulment);
		Buy buy = annulment.getBuy();
		for (Article article : buy.specification().getArticles()) {
			Double actualCount = this.count(article);
			Double boughtCount = buy.specification().getCount(article);
			stockArticles.put(article, actualCount - boughtCount);
		}
	}

	public void apply(SellAnnulment annulment) {
		costValuation.notify(annulment);
		Sell sell = annulment.getSell();
		for (Article article : sell.specification().getArticles()) {
			Double actualCount = this.count(article);
			Double soldCount = sell.specification().getCount(article);
			stockArticles.put(article, actualCount + soldCount);
		}
	}

}
