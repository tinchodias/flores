package model.price;

import java.util.HashMap;
import java.util.Map;

import model.Store;
import model.money.Pesos;
import model.stock.Article;

public class SimplePercentagePriceStrategy implements PriceStrategy {

	private final Store store;
	private Map<Article, Double> percentages = new HashMap<Article, Double>();
	private Double generalPercentage = 0.0;

	public SimplePercentagePriceStrategy(Store store) {
		this.store = store;
	}

	public Pesos priceFor(Article article) {
		Pesos cost = store.stock().cost(article);
		Double percentage = getPercentage(article);
		return cost.by(percentage);
	}

	public Double getPercentage(Article article) {
		Double percentage;
		Double particularPercentage = percentages.get(article);
		
		if (particularPercentage != null) {
			percentage = particularPercentage;
		} else {
			percentage = generalPercentage;
		}
		return percentage;
	}

	public void setPercentage(Article article, Double percentage) {
		percentages.put(article, percentage);
	}
	
	public Double getGeneralPercentage() {
		return generalPercentage;
	}

	public void setGeneralPercentage(Double generalPercentage) {
		this.generalPercentage = generalPercentage;
	}

}
