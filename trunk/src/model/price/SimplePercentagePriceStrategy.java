package model.price;

import java.util.Map;

import model.Store;
import model.money.MoneyAmount;
import model.stock.Article;
import model.util.CollectionFactory;

public class SimplePercentagePriceStrategy implements PriceStrategy {

	private final Store store;
	private Map<Article, Double> percentages = CollectionFactory.<Article, Double>newIdentityMap();
	private Double defaultPriceMargin = 0.0;

	public SimplePercentagePriceStrategy(Store store) {
		this.store = store;
	}

	public MoneyAmount priceFor(Article article) {
		MoneyAmount cost = store.stock().cost(article);
		Double margin = getPriceMargin(article);
		return cost.by(1 + margin / 100.0);
	}

	public Double getPriceMargin(Article article) {
		Double margin;
		Double particularMargin = percentages.get(article);
		
		if (particularMargin != null) {
			margin = particularMargin;
		} else {
			margin = defaultPriceMargin;
		}
		return margin;
	}

	public void setPriceMargin(Article article, Double percentage) {
		percentages.put(article, percentage);
	}
	
	public Double getDefaultPriceMargin() {
		return defaultPriceMargin;
	}

	public void setDefaultPriceMargin(Double percentage) {
		this.defaultPriceMargin = percentage;
	}

}
