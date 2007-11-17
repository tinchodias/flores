package model.price;

import java.util.Map;

import model.Store;
import model.money.MoneyAmount;
import model.stock.Article;
import model.util.CollectionFactory;
import model.util.Percentage;

public class SimplePercentagePriceStrategy implements PriceStrategy {

	private final Store store;
	private Map<Article, Percentage> percentages = CollectionFactory.newIdentityMap();
	private Percentage defaultPriceMargin = Percentage.newFor(0.0);

	public SimplePercentagePriceStrategy(Store store) {
		this.store = store;
	}

	public MoneyAmount priceFor(Article article) {
		MoneyAmount cost = store.stock().cost(article);
		Double margin = getPriceMargin(article).value();
		return cost.by(1 + margin);
	}

	public Percentage getPriceMargin(Article article) {
		Percentage margin;
		Percentage particularMargin = percentages.get(article);
		
		if (particularMargin != null) {
			margin = particularMargin;
		} else {
			margin = defaultPriceMargin;
		}
		return margin;
	}

	public void setPriceMargin(Article article, Percentage percentage) {
		percentages.put(article, percentage);
	}
	
	public Percentage getDefaultPriceMargin() {
		return defaultPriceMargin;
	}

	public void setDefaultPriceMargin(Percentage percentage) {
		this.defaultPriceMargin = percentage;
	}

}
