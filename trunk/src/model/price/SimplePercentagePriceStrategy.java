package model.price;

import java.util.Map;

import model.Store;
import model.money.Pesos;
import model.receipt.Buy;
import model.receipt.BuyAnnulment;
import model.stock.Article;
import model.util.CollectionFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class SimplePercentagePriceStrategy implements PriceStrategy {

	private final Store store;
	private Map<Article, Double> percentages = CollectionFactory.<Article, Double>newMap();
	private Double defaultPriceMargin = 0.0;

	public SimplePercentagePriceStrategy(Store store) {
		this.store = store;
	}

	public Pesos priceFor(Article article) {
		Pesos cost = store.stock().cost(article);
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

	public void apply(Buy buy) {
		for (Article article : buy.items().getArticles()) {
			Double margin = buy.items().getPriceMargin(article);
			this.setPriceMargin(article, margin);
		}
	}

	public void apply(BuyAnnulment annulment) {
		// TODO not implemented
		throw new NotImplementedException();
	}

}
